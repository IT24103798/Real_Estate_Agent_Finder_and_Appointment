<%--
  Created by IntelliJ IDEA.
  User: akila
  Date: 5/17/2025
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.agent.model.Agent" %>
<%@ page import="java.util.List" %>
<html>
<head>
  <title>Filtered Agents</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      padding: 20px;

      color: black;
      display: flex;
      align-items: center;
      flex-direction: column;
      gap: 20px;
    }


    .cards-container {
      display: flex;
      flex-wrap: wrap;
      justify-content: flex-start;
      align-items: center;
      gap: 20px;
      margin-top: 20px;
      background: rgba(250,250,250,0.2);
      backdrop-filter: blur(10px);
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
      padding: 20px;
      border-radius: 20px;
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
      font-size: 28px;
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

<h2>Agents Matching Your Search</h2>

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

<a href="index.jsp"><button type="button" class="sort-button">Back to Search</button></a>

</body>
</html>

