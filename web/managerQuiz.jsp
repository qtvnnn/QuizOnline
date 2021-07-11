<%-- 
    Document   : managerQuiz
    Created on : Mar 10, 2020, 9:18:02 PM
    Author     : tranb
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Account"%>
<%@page import="entity.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="CSS/css1.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/managerCss.css" rel="stylesheet" type="text/css"/>
        <% int count = (Integer) request.getAttribute("count"); %>
        <% ArrayList<Question> listQ = (ArrayList<Question>) request.getAttribute("listQ");%>
        <%int pagecount = (Integer) request.getAttribute("pagecount"); %>
        <% SimpleDateFormat df = (SimpleDateFormat) request.getAttribute("df");%>

        <script src="js/script.js" type="text/javascript"></script>

    </head>
    <body>
        <div class="tong">
            <jsp:include page="header.jsp"/>
            <div class="login">
                <a class="text-color">Number of questions : <%= count%> </a>
                <table>
                    <tr>
                        <th class="color-user">Question</th>
                        <th class="color-user">DateCreated</th> 
                        <th class="color-user">Delete</th>
                    </tr>
                    <% for (int i = 0; i < listQ.size(); i++) {%>
                    <tr>
                        <td class="text-color"><%= listQ.get(i).getContent()%></td>

                        <td class="text-color"><%= df.format(listQ.get(i).getDate_Create())%></td>
                        <td> <form onsubmit="return confirm('Are you really want to delete this question?')"  action="manager" method="post">
                                <button type="submit" name="delete" value="<%= listQ.get(i).getId()%>">Delete</button>
                            </form>
                        </td>
                    </tr>
                    <%}%>
                </table>
                <span class="padding">
                    <%for (int i = 1; i <= pagecount; i++) {%>
                    <a href="./manager?id=<%=i%>" type="link"><%=i%></a>
                    <% }%>
                </span>
            </div>
        </div>


    </body>
</html>
