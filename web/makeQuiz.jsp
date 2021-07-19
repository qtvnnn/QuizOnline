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
        <title>JSP Page</title>
        <link href="./CSS/css1.css" rel="stylesheet">
        <link href="CSS/makeQuizCss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="tong" id="make">
            <%@include file="header.jsp"%>

            <div class="login">
                <form id="makeQuiz" action="makeQuiz" method="post">
                    <table>
                        <tr>
                            <td> <label class="text-color">Question: </label></td>
                            <td> <textarea id="question" rows="7" cols="70" name="question" required=""><c:if test="${question != null}">${question}</c:if></textarea></td>
                            </tr>
                            <tr>
                                <td>  <label class="text-color" for="option1">Option1: </label></td>
                                <td> <textarea id="option1"  rows="3" cols="70" class="form-option1" required="" name="option1"><c:if test="${listOption != null}">${listOption.get(0)}</c:if></textarea></td>
                            </tr>
                            <tr>
                                <td> <label for="option2" class="text-color">Option2: </label></td>
                                <td> <textarea id="option2"  rows="3" cols="70" class="form-option2" required="" name="option2"><c:if test="${listOption != null}">${listOption.get(1)}</c:if></textarea></td>
                            </tr>
                            <tr>
                                <td> <label for="option3" class="text-color">Option3: </label></td>
                                <td> <textarea id="option3" rows="3" cols="70" class="form-option3" required="" name="option3"><c:if test="${listOption != null}">${listOption.get(2)}</c:if></textarea></td>
                            </tr>
                            <tr>
                                <td> <label for="option4" class="text-color">Option4: </label></td>
                                <td> <textarea id="option4"  rows="3" cols="70" class="form-option4" required="" name="option4"><c:if test="${listOption != null}">${listOption.get(3)}</c:if></textarea></td>
                            </tr>
                        </table>
                        <div>
                            <label for="answer" class="text-color">Answer(s): </label>
                            <input type="checkbox" id="option1" name="cbxo1" <c:if test="${flaq != null}">checked=""</c:if> value="true">
                            <label for="option1" class="text-color">Option 1</label>
                            <input type="checkbox" id="option2" name="cbxo2" <c:if test="${flaq != null}">checked=""</c:if> value="true">
                            <label for="option2" class="text-color">Option 2</label>
                            <input type="checkbox" id="option3" name="cbxo3" <c:if test="${flaq != null}">checked=""</c:if> value="true">
                            <label for="option3" class="text-color">Option 3</label>
                            <input type="checkbox" id="option4" name="cbxo4" <c:if test="${flaq != null}">checked=""</c:if> value="true">
                            <label for="option4" class="text-color">Option 4</label>
                        </div>
                        <div>
                            <input type="button" onclick="checkQuestion()" class="button" id="btn-makeQ" value="Save">
                        </div>
                    <c:if test="${message != null}">
                        <a>${message}</a>
                    </c:if>
                </form>
            </div>
        </div>
        <script>
            function checkQuestion() {
                var question = document.getElementById("question").value;
                var option1 = document.getElementById("option1").value;
                var option2 = document.getElementById("option2").value;
                var option3 = document.getElementById("option3").value;
                var option4 = document.getElementById("option4").value;

                if (!question.replace(/^\s+|\s+$/g, "")) {
                    alert('Question is only whitespace');
                    return;
                }
                if (!option1.replace(/^\s+|\s+$/g, "")) {
                    alert('option1 is only whitespace');
                    return;
                }
                if (!option2.replace(/^\s+|\s+$/g, "")) {
                    alert('option2 is only whitespace');
                    return;
                }
                if (!option3.replace(/^\s+|\s+$/g, "")) {
                    alert('option3 is only whitespace');
                    return;
                }
                if (!option4.replace(/^\s+|\s+$/g, "")) {
                    alert('option4 is only whitespace');
                    return;
                }
                document.getElementById("makeQuiz").submit();
            }
        </script>
    </body>
</html>
