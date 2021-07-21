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
        <link href="./CSS/css1.css" rel="stylesheet">
        <link href="CSS/takeQuiz3Css.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="tong">
            <%@include file="header.jsp"%>
            <div class="login" >
                <c:if test="${reject == null}">
                    <a class="text-color">Your score </a>
                    <a class="color-user" style="color: ${color}">${yourScore}</a>
                </c:if>
                <c:if test="${reject != null}">
                    <a>You are cheating. Result had been denied! </a>
                </c:if>
                <div class="down">
                    <a class="text-color">Take another test</a>
                    <form action="takeQuiz" method="get">
                        <button type="submit" class="button">Start</button>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
