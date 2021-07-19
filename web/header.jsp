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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./CSS/headerCss.css" rel="stylesheet">
    </head>
    <body class="bheader">
        <div class="header">
            <div class="inside">
                <c:if test="${acc != null}">
                    <a href="HomeController">Home</a>
                </c:if>
                <c:if test="${acc == null}">
                    <a href="login">Home</a>
                </c:if>
                <a href="takeQuiz">Take Quiz</a>
                <a href="makeQuiz">Make Quiz</a>
                <a href="manager">Manage Quiz</a>
                <c:if test="${acc != null}">
                    <a href="logout">Log Out</a>
                </c:if>
            </div>
        </div>
    </body>
</html>
