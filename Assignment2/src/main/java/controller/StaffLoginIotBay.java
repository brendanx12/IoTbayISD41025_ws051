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
@WebServlet(name = "StaffLoginIotBay", urlPatterns = {"/StaffLoginIotBay"})
public class StaffLoginIotBay extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    HttpSession session = request.getSession();
    String email = request.getParameter("email");
    String inputtedPassword = request.getParameter("password"); 
    //get the instance of the DBManager isntantiated in the Connection Code
    DBManager manager = (DBManager) session.getAttribute("manager");
    Customer newCustomer = null;
    
    //now we're gonna test the findStudent method
    //this function is very important as we use it to loginand stuff 
    //please un comment it
    
    try {
    //then we're gonna run the search with email function
    newCustomer = manager.findStaff(email,inputtedPassword);
    if(newCustomer != null){
        session.setAttribute("Customer",newCustomer);
        //get the email of the logged in customer and send it so an access log can be created
        manager.createTimeStamp(newCustomer.getEmail());
        request.getRequestDispatcher("staffMainPage.jsp").include(request,response);
        //out.println(newCustomer.getFirstName());
        
    }else{
        //else we're gonna send u back to the login page
        session.setAttribute("passIsCorrect","false");
        request.getRequestDispatcher("staff-login.jsp").include(request,response);
    }
} catch (SQLException | NullPointerException ex) {
    System.out.println("Vague Exception Occured!");
}
          
          
    
                      
        }  
}  

