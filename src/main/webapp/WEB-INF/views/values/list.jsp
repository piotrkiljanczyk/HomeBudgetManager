<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PKiljanczyk1
  Date: 06.10.2022
  Time: 22:11
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
<h1>All values</h1>
<div style="padding-left:16px">
<div>
    <a href="/add-value">Add new value</a>
</div>
<div>
    <table>
        <tr>
            <th>Value</th>
            <th>Type</th>
            <th>Date</th>
            <th>Category</th>
            <th>Owners</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="value" items="${values}">
            <tr>
                <td>${value.value}</td>
                <td>${value.type}</td>
                <td>${value.date}</td>
                <td>${value.category}</td>
                <td>
                    <c:forEach items="${value.owners}" var="owner">
                        ${owner.fullName},
                    </c:forEach>
                </td>
                <td>
                    <a href="/edit-value?id=${value.id}">Edit</a>
                    <a href="/delete-value?id=${value.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
</body>
</html>
