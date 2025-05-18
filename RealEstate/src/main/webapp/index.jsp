<%@ page import="com.example.agent.model.Agent" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agent Rating Search</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: url("zhou-xian-7tFFO6Mq5L4-unsplash.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            background-position:center;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .center-container {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 20px;
            height: 50px;
            width: 200px;
        }

        form {
            background: rgba(250,250,250,0.8);
            backdrop-filter: blur(10px);
            border-radius: 30px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 500px;
            height: 220px;
        }

        input[type="text"], input[type="submit"] {
            padding: 10px;
            margin: 10px 0;
            font-size: 16px;
        }

        .error {
            color: red;
            margin-top: 10px;
        }

        .cards-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 30px;
            gap: 20px;
        }

        .agent-card {
            background-color: white;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            width: 250px;
            padding: 20px;
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

        .search-form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .search-input {
            width: 250px;
            padding: 10px;
            font-size: 16px;
            border-radius: 20px;
            border: 1px solid #ccc;
            margin: 10px 0;
        }

        .search-button {
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 20px;
            background-color: black;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .search-button:hover {
            background-color: green;
        }

        .search-row {
            display: flex;
            align-items: center;
            gap: 10px;
            margin-top: 10px;
        }

        .sort-button {
            padding: 10px 16px;
            font-size: 16px;
            background-color: black;
            color: white;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 200px;
        }

        .sort-button:hover {
            background-color: green;
        }



    </style>





</head>
<body>

<div class="center-container">
    <form action="search" method="get" class="search-form">
        <h2>Search Agents by Minimum Rating</h2>
        <div class="search-row">
            <input type="text" name="minRating" id="minRating" placeholder="Enter minimum rating" class="search-input" required>
            <input type="submit" value="Search" class="search-button">
        </div>
        <br>
        <a href="sort"><button type="button" class="sort-button">Top Rating</button></a>
    </form>
</div>

</body>
</html>

