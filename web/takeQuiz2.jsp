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
        <link href="CSS/takeQuizCss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="tong">
            <%@include file="header.jsp"%>
            <div class="login">
                <h3 class="text-color">Welcome </h3> <a class="color-user">${acc.getUserName()}</a>
                <div id="questionPos" class="text-color">0/0</div>
                <div class="time-remaining text-color" ><a>Time remaining</a></div>
                <span id="timeDisplay" class="time-color"></span>
                <form id="quizForm" action="takeQuiz2" method="post">
                    <input type="hidden" value="${number}" name="number">

                    <c:if test="${listQ != null}">
                        <c:forEach begin="0" end="${number - 1}" var="i">
                            <div id="q${i}" class="hidden question-zone">
                                <a class="text-color">${listQ.get(i).getContent()}</a><br>
                                <c:forEach begin="0" end="${listO.size() - 1}" var="j">
                                    <c:if test="${listO.get(j).getQuestion().getId() == listQ.get(i).getId()}">
                                        <input type="checkbox" name="${listO.get(j).getId()}" value="true">
                                        <label class="text-color">${listO.get(j).getContent()}</label><br>
                                    </c:if>
                                </c:forEach>
                                <br>
                            </div>
                        </c:forEach>
                    </c:if>
                    <button type="submit" value="Submit" class="button button-submit">Submit</button>
                    <input type="button" class="button button-next" value="next" id="btn-next">
                </form>
            </div>
        </div>

        <script src="js/script.js" type="text/javascript"></script>
        <script>
            setNumber(${number});
            quizStart();
        </script>
    </body>
</html>
