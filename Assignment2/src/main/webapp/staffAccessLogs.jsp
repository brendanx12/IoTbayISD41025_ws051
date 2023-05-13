<%-- 
    Document   : accessLogsJsp
    Created on : 6 May 2023, 4:44:03 pm
    Author     : Mushini
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ page import="java.sql.*" %>
<%@ page import="workshop.dao.*" %>
<%@ page import="IoTbay.*" %>
<%@page import="workshop.*"%>
<%@page import="IoTbay.*"%>
<%@page import="controller.*"%>
<%@ page language="java" import="java.util.*" %>
<% 
    
    DBManager manager = (DBManager) session.getAttribute("manager");

%>
<link rel="stylesheet" href="style_1.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/StyleSheetForNavBar.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Access logs JSP Pages</title>
    </head>
    <BODY BGCOLOR="cyan">
        <div>
            <nav>
                <ul>
                    <li><a href="staffMainPage.jsp">Home</a></li>
                    <li><a href="LogOutController">Logout</a></li>
                    <li><a href="customerDetails.jsp">Account Settings</a></li>
                </ul>
            </nav>
            
        </div>
       <H1>Staff Access Logs </H1>
       <%
          Customer customerDetails = (Customer) session.getAttribute("Customer");
          String email = customerDetails.getEmail();
          ResultSet resultset = manager.st.executeQuery("SELECT * FROM IOTBAY.CUSTOMERACCESSLOGS WHERE ACCESSEMAIL = '" + email + "'");
       %>
      <TABLE BORDER="1">
      <TR>
      <TH>Access Email</TH>
      <TH>Access Time</TH>
      <TH>Access Type</TH>
      
      </TR>
      <% while(resultset.next()){ %>
      <TR>
       <TD> <%= resultset.getString(1) %>&nbsp;</TD>
       <TD> <%= resultset.getString(2) %>&nbsp;</TD>
       <TD> <%= resultset.getString(3) %>&nbsp;</TD>
      </TR>
      <% } %>
     </TABLE>
</html>
