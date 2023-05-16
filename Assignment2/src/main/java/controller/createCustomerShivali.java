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
@WebServlet(name = "createCustomerShivali", urlPatterns = {"/createCustomerShivali"})
public class createCustomerShivali extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    HttpSession session = request.getSession();
    
     
    //get the instance of the DBManager isntantiated in the Connection Code
    DBManager manager = (DBManager) session.getAttribute("manager");
    Customer newCustomer = null;
    
    //now we're gonna test the findStudent method
    //this function is very important as we use it to loginand stuff 
    //please un comment it
    
        String firstName = request.getParameter("firstName");
        String middleName= request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        int mobileNumber = Integer.parseInt(request.getParameter("mobileNumber"));
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        int postcode = Integer.parseInt(request.getParameter("postcode"));
        String password = request.getParameter("password");
    
        try {

            manager.createCustomer(firstName, middleName, lastName, email, mobileNumber, address, state, city, postcode, password);
            
            request.getRequestDispatcher("createCustomer.jsp").include(request,response);
            
            
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Vague Exception Occured!");
        }
    }  
}  

