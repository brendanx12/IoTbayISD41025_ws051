<%-- 
    Document   : validate.jsp
    Created on : Apr 5, 2023, 2:50:20 PM
    Author     : benja
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<jsp:useBean id='customer1' scope='session' class='IoTbay.Customer' />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Validate</title>
    </head>
    <body>
        <!-- values given at login page are taken here and checks if the valid details are not -->
		<%
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(email.equals(customer1.getEmail()) && password.equals(customer1.getPassword())){
			//if the user is valid, then this block executes and WE ARE KEEPING THE USER IN A SESSION
			response.sendRedirect("welcomeBack.jsp"); //AND WE REDIRECTED TO LOGIN PAGE
			
		}else{
			//IF THE USER IS NOT AUTHORISED THEN AGAIN HE WILL BE REDIRECTED TO THE SAME LOGIN PAGE
                        session.setAttribute("loginError", "Sorry, wrong credentials. Please try again."); // store error message in session
                        response.sendRedirect("login.jsp");
		}
		%>
    </body>
</html>
