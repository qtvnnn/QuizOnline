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
        <link href="./CSS/css1.css" rel="stylesheet">
    </head>
    <body>
        <div class="tong">
            <jsp:include page="header.jsp"/>
            <div class="login">
                <br>
                <h3>Welcome ! ${acc.getUserName()}</h3> <br>
                <h4>Account Information</h4> <br>
                <a>Account Type: ${acc.getUserType().getType()}</a><br><br>
                <a>Email: ${acc.getEmail()}</a>
            </div>
        </div>
    </body>
</html>
