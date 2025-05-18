<%--
  Created by IntelliJ IDEA.
  User: akila
  Date: 5/17/2025
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.agent.model.Agent" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Top Rated Agents</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background: #f2f2f2;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .cards-container {
            display: flex;
            flex-direction: column;
            justify-content: flex-start; /* Align items to the top */
            align-items: center; /* Center the items horizontally */
            gap: 20px; /* Space between the cards */
            margin-top: 20px;
        }

        .agent-card {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            width: 250px;
            text-align: center;
        }

        .agent-card h3 {
            margin: 0;
            font-size: 20px;
            color: #333;
        }

        .agent-card p {
            margin: 10px 0 0;
            font-size: 16px;
            color: #666;
        }

        .stars {
            font-size: 28px; /* Increased size here */
        }

        .star-filled {
            color: gold;
        }

        .star-empty {
            color: #ccc;
        }

        a {
            margin-top: 30px;
            display: inline-block;
            text-decoration: none;
            color: #007BFF;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;

        }
        .sort-button {
            padding: 10px 16px;
            font-size: 16px;
            background-color: black;
            color: white;
            border: none;
            border-radius: 90px;
            cursor: pointer;
            transition: background-color 0.3s;

        }

        .sort-button:hover {
            background-color: green;
        }
    </style>

</head>
<body>
<h2> Top Rated Agents </h2>
<a href="index.jsp"><button type="button" class="sort-button">Back to Search</button></a>

<%
    List<Agent> agents = (List<Agent>) request.getAttribute("agents");
    if (agents == null || agents.isEmpty()) {
%>
<p>No agents found with that rating.</p>
<%
} else {
%>
<div class="cards-container">
    <%
        for (Agent agent : agents) {
            int filledStars = (int) Math.round(agent.getRating());
            int totalStars = 5;
    %>
    <div class="agent-card">
        <h3><%= agent.getName() %></h3>
        <p class="stars">
            <% for (int i = 0; i < filledStars; i++) { %>
            <span class="star-filled">&#9733;</span>
            <% } %>
            <% for (int i = filledStars; i < totalStars; i++) { %>
            <span class="star-empty">&#9733;</span>
            <% } %>
        </p>
        <p>(<%= agent.getRating() %>)</p>
    </div>
    <%
        }
    %>
</div>
<%
    }
%>


</body>
</html>

