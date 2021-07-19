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
        <link href="CSS/css1.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/error.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <div class="tong" >
            <%@include file="header.jsp"%>
            <div class="login">
                <a class="text-color">${errorMessage}</a>
                <a href="login" class="click">Click here</a>
                <a class="text-color">&nbsp     to go homepage</a>
            </div>
        </div>>
    </body>
</html>
