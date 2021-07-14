<%-- 
/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0001<br>
 * Online Quiz<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-29    1.0        NangNN           First Version<br>
 */
--%>

<%@page import="entity.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./CSS/headerCss.css" rel="stylesheet">
        <% Account acc = (Account) request.getSession().getAttribute("acc"); %>
    </head>
    <body class="bheader">
        <div class="header">
            <div class="inside">
                <%if (acc != null) { %>
                <a href="HomeController">Home</a>
                <%}else {%>
                <a href="login">Home</a>
                <%}%>
                
                <a href="takeQuiz">Take Quiz</a>
                <a href="makeQuiz">Make Quiz</a>
                <a href="manager">Manage Quiz</a>
                <%if (acc != null) {%>
                <a href="logout">Log Out</a>
                <%}%>
            </div>
        </div>
    </body>
</html>
