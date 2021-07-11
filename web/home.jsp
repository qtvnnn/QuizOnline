<%-- 
    Document   : home
    Created on : Feb 29, 2020, 7:59:27 AM
    Author     : tranb
--%>

<%@page import="entity.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./CSS/css1.css" rel="stylesheet">
        <%Account acc = (Account) request.getSession().getAttribute("acc"); %>
    </head>
    <body>
        <div class="tong">
            <jsp:include page="header.jsp"/>
            <div class="login">
                <br>
                <h3>Welcome ! <%= acc.getUserName()%></h3> <br>
                <h4>Account Information</h4> <br>
                <a>Account Type: <%= acc.getUserType().getType()%></a><br><br>
                <a>Email: <%=acc.getEmail()%></a>
            </div>
        </div>
    </body>
</html>
