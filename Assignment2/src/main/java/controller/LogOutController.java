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
@WebServlet(name = "LogOutController", urlPatterns = {"/LogOutController"})
public class LogOutController extends HttpServlet {

    
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            
        throws ServletException, IOException {  
        
         //response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    HttpSession session = request.getSession();
    DBManager manager = (DBManager) session.getAttribute("manager");
    Customer newCustomer = (Customer) session.getAttribute("Customer");

    try {
    //then we're gonna run the search with email function
    manager.createTimeStampLogout(newCustomer.getEmail());
    System.out.print("Succesfully added boy! check yo database");
} catch (SQLException | NullPointerException ex) {
    System.out.println("Vague Exception Occured!");
}
        
             
             session.invalidate();
             request.getRequestDispatcher("index.jsp").include(request, response);
        }  
    
  
}
