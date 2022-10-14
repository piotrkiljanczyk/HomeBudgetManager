<%--
  Created by IntelliJ IDEA.
  User: PKiljanczyk1
  Date: 13.10.2022
  Time: 20:55
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

<div style="padding-left:16px">
    <h2><center>Home Budget Manager</center></h2>
</div>
<%--<center>--%>
<%--<form method="post">--%>
<%--    <div class="form-outline form-white mb-4">--%>
<%--        <input type="text" name="username" id="username" class="form-control form-control-lg" />--%>
<%--        <label class="form-label" for="username">Login</label>--%>
<%--    </div>--%>

<%--    <div class="form-outline form-white mb-4">--%>
<%--        <input type="password" name="password" id="typePasswordX" class="form-control form-control-lg" />--%>
<%--        <label class="form-label" for="typePasswordX">Password</label>--%>
<%--    </div>--%>

<%--    <button class="btn btn-outline-light btn-lg px-5" type="submit">Sign in</button>--%>

<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

<%--</form>--%>
<%--</center>--%>
</body>
</html>