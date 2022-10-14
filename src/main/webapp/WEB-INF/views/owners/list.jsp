<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h2>All owners</h2>
<div style="padding-left:16px">
    <div>
        <a href="/add-owner">Add new owner</a>
    </div>
    <div>
        <table>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="owner" items="${owners}">
                <tr>
                    <td>${owner.firstName}</td>
                    <td>${owner.lastName}</td>
                    <td>
                        <a href="/edit-owner?id=${owner.id}">Edit</a>
                        <a href="/delete-owner?id=${owner.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>