<%--
  Created by IntelliJ IDEA.
  User: PKiljanczyk1
  Date: 06.10.2022
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        .hide {
            display: none;
        }

        .show {
            display: block;
        }

        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #04AA6D;
            color: white;
        }
    </style>
</head>
<body>

<div class="topnav">
    <a class="active" href="/">Home</a>
    <a href="/list-values">Values</a>
    <a href="/list-owners">Owners</a>
</div>
<h1>Delete owner</h1>
<div style="padding-left:16px">
    <div class="${ownerHasValue ? 'show' : 'hide'}">
        You can't delete Owner because he has value
    </div>
<div class="${ownerHasValue ? 'hide' : 'show'}">Do you like do delete ${owner.fullName}?
    <form method="post" action="/delete-owner">
        <input type="hidden" name="id" value="${owner.id}"/>
        <button type="submit">Yes</button>
    </form>
    <form method="get" action="/list-owners">
        <button type="submit">No</button>
    </form>
</div>
</div>
</body>
</html>
