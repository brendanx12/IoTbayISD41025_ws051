<%-- 
    Document   : LoginExample
    Created on : 26 Apr 2023, 2:41:05 pm
    Author     : Mushini
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
                                <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Login Page</title>
	</head>

	<body>
		<form action="LoginServlet">

			Please enter your username 		
			<input type="text" name="un"/><br>		
		
			Please enter your password
			<input type="text" name="pw"/>
			
			<input type="submit" value="submit">			
		
		</form>
	</body>
</html>
