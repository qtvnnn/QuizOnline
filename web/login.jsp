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
        <link href="./CSS/registerCss.css" rel="stylesheet">
        <%String notification = (String) request.getAttribute("notification"); %>
    </head>

    <body>
        <div class="tong" >
            <jsp:include page="header.jsp"/>

            <div class="login">
                <h3 class="font-wight">Login Form</h3>
                <form action="login" method="post">
                    <div>
                        <label for="user" class="text-color">User Name: </label>
                        <input type="text" id="user" required="" name="user" class="form-user color-textbox" >   
                    </div>
                    <div>
                        <label for="pass" class="text-color">Password: </label>
                        <input type="password" required="" id="pass" name="pass" class="form-pass color-textbox" >   
                    </div>
                    <div>
                        <button type="submit" class="button">Sign in</button>
                        <a href="register" class="link-href text-color"><b>Register</b></a>
                    </div>
                    <%if (notification != null) {%>
                    <a><%= notification%></a>
                    <%}%>
                </form>
            </div>
        </div>
    </body>
</html>
