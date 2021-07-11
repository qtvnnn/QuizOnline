<%-- 
    Document   : takeQuiz3
    Created on : Mar 15, 2020, 7:50:42 PM
    Author     : tranb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./CSS/css1.css" rel="stylesheet">
        <link href="CSS/takeQuiz3Css.css" rel="stylesheet" type="text/css"/>
        <%String yourScore = (String) request.getAttribute("yourScore");%>
        <%String color = (String) request.getAttribute("color");%>
        <%String reject = (String) request.getAttribute("reject"); %>
    </head>
    <body>
        <div class="tong">
            <jsp:include page="header.jsp"/>
            <div class="login" >
                <%if(reject==null){ %>
                <a class="text-color">Your score </a>
                <a class="color-user" style="color: <%=color%>"><%= yourScore%></a>
                <%} else {%>
                <a>You are cheating. Result had been denied! </a>
                <%}%>
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
