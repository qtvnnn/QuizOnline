<%-- 
    Document   : Resgistration
    Created on : Feb 26, 2020, 8:13:20 AM
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
        <link href="./CSS/registerCss.css" rel="stylesheet">
        <%
            Account account  = (Account) request.getAttribute("accountFail");
            String notification = (String) request.getAttribute("notification");
        %>
    </head>
    <body>

        <div class="tong">
            <jsp:include page="header.jsp"/>
            <div class="login" >
                <h3 class="header font-wight">Registration Form</h3>
                <form id="register" action="register" method="post">
                    <div>
                        <label for="user" class="text-color">User Name: </label>
                        <input type="text" id="user" required="" name="user" <%if (account != null) {%> value="<%= account.getUserName()%>" <%}%> class="form-user color-textbox" >   
                    </div>

                    <div>
                        <label for="pass" class="text-color">Password: </label>
                        <input type="password" id="pass" required="" name="pass" class="form-pass color-textbox" >   
                    </div>

                    <div>
                        <label for="type" class="text-color">User Type:</label>
                        <select id="type" class="cbxtype" name="type">
                            <option value="2">Teacher</option>
                            <option value="1" <%if (account!= null && account.getUserType().getId()== 1) {%> selected="" <%}%> >Student</option>
                        </select>
                    </div>

                    <div>
                        <label class="text-color" for="email">Email: </label>
                        <input type="email" id="email" required="" name="email" <%if (account != null) {%> value="<%=account.getEmail()%>" <%}%>  class="form-email color-textbox">
                    </div>

                    <div>
                        <input type="button" onclick="checkRegis()" class="button"  value="Register">
                    </div>
                </form>
                <%if (notification != null) {%>
                <a><%= notification%></a>
                <%}%>
            </div>
            <script>
                function hasWhiteSpace(s)
                {
                    return s.indexOf(' ') >= 0;
                }

                function checkRegis() {
                    var username = document.getElementById("user").value;
                    if (hasWhiteSpace(username)) {
                        alert('Username can not have space');
                    }
                    else{
                        document.getElementById("register").submit();
                    }
                }
            </script>
    </body>
</html>
