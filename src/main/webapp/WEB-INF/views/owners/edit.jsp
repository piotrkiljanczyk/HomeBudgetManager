<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: PKiljanczyk1
  Date: 06.10.2022
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
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
<h1>Edit owners</h1>
<div style="padding-left:16px">
<a href="/list-owners">Return</a>
<div>
    <form:form modelAttribute="owner" method="post" action="/edit-owner">
        <div>
            First name: <form:input path="firstName"/><form:errors path="firstName"/>
        </div>
        <div>
            Last name: <form:input path="lastName"/><form:errors path="lastName"/>
        </div>
        <form:hidden path="id"/>
        <form:button type="submit">Edit</form:button>
    </form:form>
</div>
</div>
</body>
</html>
