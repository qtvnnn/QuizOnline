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
<%@page import="entity.Question"%>
<%@page import="entity.Option"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./CSS/css1.css" rel="stylesheet">
        <link href="CSS/takeQuizCss.css" rel="stylesheet" type="text/css"/>
        <% Account acc = (Account) request.getSession().getAttribute("acc"); %>
        <% ArrayList<Question> listQ = (ArrayList<Question>) request.getAttribute("listQ"); %>
        <% ArrayList<Option> listO = (ArrayList<Option>) request.getAttribute("listO"); %>  
        <% Integer number = (Integer) request.getAttribute("number"); %> 
    </head>
    <body>



        <div class="tong">
            <jsp:include page="header.jsp"/>
            <div class="login">
                <h3 class="text-color">Welcome </h3> <a class="color-user"><%= acc.getUserName()%></a>
                <div id="questionPos" class="text-color">0/0</div>
                <div class="time-remaining text-color" ><a>Time remaining</a></div>
                <span id="timeDisplay" class="time-color"></span>
                <form id="quizForm" action="takeQuiz2" method="post">
                    <input type="hidden" value="<%= number%>" name="number">

                    <% if (listQ != null) { %>
                    <%for (int i = 0; i < number; i++) {%>
                    <div id="q<%=i%>" class="hidden question-zone">
                        <a class="text-color"><%= listQ.get(i).getContent()%></a><br>
                        <%for (int j = 0; j < listO.size(); j++) { %>
                        <%if (listO.get(j).getQuestion().getId()== listQ.get(i).getId()) {%>
                        <input type="checkbox" name="<%= listO.get(j).getId()%>" value="true">
                        <label class="text-color"><%= listO.get(j).getContent()%></label><br>
                        <%}%>
                        <%}%>
                        <br>
                    </div>
                    <%}%>
                    <%}%>
                    <button type="submit" value="Submit" class="button button-submit">Submit</button>
                    <input type="button" class="button button-next" value="next" id="btn-next">
                </form>
            </div>
        </div>

        <script src="js/script.js" type="text/javascript"></script>
        <script>
            setNumber(<%=number%>);
            quizStart();
        </script>


    </body>
</html>
