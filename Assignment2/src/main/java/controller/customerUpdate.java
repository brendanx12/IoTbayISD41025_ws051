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

/**
 *
 * @author Mushini
 */
@WebServlet(name = "customerUpdate", urlPatterns = {"/customerUpdate"})
public class customerUpdate extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    HttpSession session = request.getSession();
    //get the instance of the DBManager isntantiated in the Connection Code
    DBManager manager = (DBManager) session.getAttribute("manager");

    Customer customerDetails = (Customer) session.getAttribute("Customer");
    String firstName = request.getParameter("firstName");
    String middleName= request.getParameter("middleName");
    String lastName = request.getParameter("lastName");
    //get the email from the session
    String email = customerDetails.getEmail();
    int mobileNumber = Integer.parseInt(request.getParameter("mobileNumber"));
    String address = request.getParameter("address");
    String state = request.getParameter("state");
    String city = request.getParameter("city");
    int postcode = Integer.parseInt(request.getParameter("postcode"));
    //String password = customerDetails.getPassword();
    String password = request.getParameter("password");
    
   
    
    try {
    //then we're gonna run the search with email function
    if(firstName != null){
        
        //out.println(newCustomer.getFirstName());
        manager.updateCustomer(firstName, middleName,lastName,email,mobileNumber,address,state,city,postcode,password);
        //get the new details by getting the customer object instance blah blah lol
        customerDetails = manager.findCustomer(email, password);
        session.setAttribute("Customer", customerDetails);
        //manager.findCustomer(email, password);
        request.getRequestDispatcher("customerDetails.jsp").include(request,response);
    }else{
        //else we're gonna send u back to the login page
        //use this to display "Invalid entry"
        session.setAttribute("passIsCorrect","false");
        request.getRequestDispatcher("customerDetails.jsp").include(request,response);
    }
} catch (SQLException ex) {
   Logger.getLogger(customerUpdate.class.getName()).log(Level.SEVERE, null, ex);
}            
        } 
}
