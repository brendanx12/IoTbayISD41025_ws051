/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;
import java.io.*;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import workshop.dao.*;
import IoTbay.*;
import java.io.*;  
import java.sql.*;
import IoTbay.*;
import java.sql.Timestamp;
import java.sql.ResultSet;
import javax.naming.ldap.ManageReferralControl;
import workshop.dao.*;
/**
 *
 * @author Mushini
 */
@WebServlet(name = "viewAccessLogs", urlPatterns = {"/viewAccessLogs"})


public class viewAccessLogs extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws IOException {   
    HttpSession session = request.getSession();
    Customer currentCustomer = (Customer) session.getAttribute("Customer");
    String email = currentCustomer.getEmail();
    //get the instance of the DBManager isntantiated in the Connection Code
    DBManager manager = (DBManager) session.getAttribute("manager");
    
    
    
   
    try {
    
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>Access Log</h1>");
    //String query = "SELECT * FROM IOTBAY.CUSTOMER WHERE USEREMAIL= '" + email + "'";
    String accessQuery = "SELECT * FROM IOTBAY.CUSTOMERACCESSLOGS WHERE ACCESSEMAIL = '" + email + "'";
    //SELECT * FROM IOTBAY.CUSTOMER WHERE USERFIRSTNAME = 'John';
    ResultSet rs = manager.st.executeQuery(accessQuery);
    out.println("<table border=1 width=50% height=50%>");  
    out.println("<tr><th>Email</th><th>Time Accessed</th><th>Access </th><tr>");  
    while(rs.next()){
        String accessEmail = rs.getString(1);
        String accessTime = rs.getString(2);
        String accessType = rs.getString(3);
        out.println("<tr><td>" + accessEmail + "</td><td>" + accessTime + "</td><td>" + accessType + "</td></tr>");
    }  
    out.println("</table>");  
    out.println("</html></body>");
} catch (SQLException ex) {
   Logger.getLogger(customerUpdate.class.getName()).log(Level.SEVERE, null, ex);
}   
          
          
    
                      
        }  
}  

