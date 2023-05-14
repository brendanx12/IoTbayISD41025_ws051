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
import java.util.List;
import IoTbay.*;

/**
 *
 * @author Mushini
 */
@WebServlet(name = "GettingPayment", urlPatterns = {"/GettingPayment"})
public class GettingPayment extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    // Retrieve the user ID from the session
        System.out.print("ENTRO AL SERVLET");
        int paymentDetailsId = Integer.parseInt(request.getParameter("paymentDetailsId"));
        int userID = Integer.parseInt(request.getParameter("userID"));
        System.out.print("ENTRO AL SERVLET"+paymentDetailsId);
        
        
    }
}