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
 * @author benja
 */
@WebServlet(name = "AddPaymentDetails", urlPatterns = {"/AddPaymentDetails"})
public class AddPaymentDetails extends HttpServlet {

   //basic required code for servlets
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    HttpSession session = request.getSession();
    DBManager manager = (DBManager) session.getAttribute("manager");
    
    int user_id = Integer.parseInt(request.getParameter("user_id"));
    String card_number = request.getParameter("card_number");
    String card_holder_name = request.getParameter("card_holder_name");
    String card_holder_lastname = request.getParameter("card_holder_lastname");
    String expiry_date = request.getParameter("expiry_date");
    int card_CVV = Integer.parseInt(request.getParameter("card_CVV"));
    
    //now we're gonna do the DBManager fucntions that I created to register a user
    //we need to check if the user email is already int he databaase
    //if it isnt then we can register with that email
    try {
    manager.addCard(user_id, card_number, card_holder_name, card_holder_lastname, expiry_date,
        card_CVV);
    System.out.print("Succesfully added card! check yo database");
    request.getRequestDispatcher("pay.jsp").forward(request,response);
} catch (SQLException | NullPointerException ex) {
    System.out.println("Vague Exception Occured!");
}
          
          
    
                      
        }  

}
