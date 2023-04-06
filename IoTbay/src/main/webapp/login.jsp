<%-- 
    Document   : login
    Created on : 1 Apr 2023, 9:57:45 pm
    Author     : brend
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/StyleSheetForNavBar.css">
<link rel="stylesheet" href="css/bootstrap.css">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
       
    </head>
    <body>
        <%
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            // check if there is a login error message in the session
            String loginError = (String) session.getAttribute("loginError");
            session.removeAttribute("loginError"); // remove the error message from session
        %>
        <div>
        <nav>
                <ul>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="register2.jsp">Register</a></li>
                </ul>
        </nav>
        
        <div class="container">
            <div class="title">Login</div>
            <div class="content">
                <form action="validate.jsp" method="POST">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input type="text" placeholder="Enter your email" name='email' required>
                        </div>
                        <div class="input-box">
                            <span class="details">Password</span>
                            <input type="text" placeholder="Enter your password" name='password' required>
                        </div>
                    </div>
                    <% if (loginError != null) {
                    // if there is an error message, display it
                    %>
                    <div class="error"><%= loginError %></div>
                    <%
                     } %>
                    <div class="button">
                        <input type="submit" value="Login">
                    </div>
                    <form align="center">
                        <label for="register">Don't have an account: <a href="register2.jsp">Click here</a></label>
                    </form>
                </form>
            </div>
        </div>
        </div>
    </body>
</html>
