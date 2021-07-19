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
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="CSS/css1.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/managerCss.css" rel="stylesheet" type="text/css"/>

        <script src="js/script.js" type="text/javascript"></script>

    </head>
    <body>
        <div class="tong">
            <%@include file="header.jsp"%>

            <div class="login">
                <a class="text-color">Number of questions : ${count}</a>
                <table>
                    <tr>
                        <th class="color-user">Question</th>
                        <th class="color-user">DateCreated</th> 
                        <th class="color-user">Delete</th>
                    </tr>
                    <c:forEach begin="0" end="${listQ.size()}" var="i" items="${listQ}">
                        <tr>
                            <td class="text-color">${i.getContent()}</td>
                            <td class="text-color">${df.format(i.getDateCreate())}</td>
                            <td> <form onsubmit="return confirm('Are you really want to delete this question?')"  action="manager" method="post">
                                    <button type="submit" name="delete" value="${i.getId()}">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <span class="padding">
                    <c:forEach begin="1" end="${pagecount}" var="i">
                        <a href="./manager?id=${i}" type="link">${i}</a>
                    </c:forEach>
                </span>
            </div>
        </div>


    </body>
</html>
