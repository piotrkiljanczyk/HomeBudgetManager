<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<h1>Add new value</h1>
<div style="padding-left:16px">

<form:form modelAttribute="value" method="post" action="/add-value">
    <div>
        Value: <form:input type="number" path="value" value="0"/><form:errors path="value"/>
    </div>
    <div>
        Type:
        <form:select path="type" items="${types}" multiple="false"/>
    </div>
    <div>
        Category: <form:select path="category" items="${categories}" multiple="false"/>
    </div>
    <div>
        Full Name: <form:select path="owners" items="${owners}" itemValue="id" itemLabel="fullName" multiple="false"/>
        <a href="/add-owner">Add new owner</a>
    </div>
    <form:button type="submit" disabled="${owners.isEmpty()}">Add</form:button>
</form:form>
</div>
</body>
</html>
