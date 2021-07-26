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
        <link href="./CSS/registerCss.css" rel="stylesheet">
    </head>
    <body>

        <div class="tong">
            <%@include file="header.jsp"%>
            <div class="login" >
                <h3 class="header font-wight">Registration Form</h3>
                <c:if test="${notification != null}">
                    <a style="color:red;">${notification}</a>
                </c:if>
                <form id="register" action="register" method="post">
                    <div>
                        <label for="user" class="text-color">User Name: </label>
                        <input type="text" id="user" required="" maxlength="20" name="user" value="${accountFail != null ? accountFail.getUserName() : ''}" class="form-user color-textbox" >   
                    </div>

                    <div>
                        <label for="pass" class="text-color">Password: </label>
                        <input type="password" id="pass" required="" maxlength="20" name="pass" class="form-pass color-textbox" >   
                    </div>

                    <div>
                        <label for="type" class="text-color">User Type:</label>
                        <select id="type" class="cbxtype" name="type">
                            <option value="2">Teacher</option>
                            <option value="1" <c:if test="${accountFail != null && accountFail.getUserType().getId() == 1}">selected=""</c:if> >Student</option>
                        </select>
                    </div>

                    <div>
                        <label class="text-color" for="email">Email: </label>
                        <input type="email" id="email" required="" maxlength="30" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" name="email" value="${accountFail != null ? accountFail.getEmail() : ''}" class="form-email color-textbox">
                    </div>

                    <div>
                        <input type="submit" class="button"  value="Register">
                    </div>
                </form>
            </div>
    </body>
</html>
