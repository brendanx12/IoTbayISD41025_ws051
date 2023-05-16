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
 * @author benja
 */
@WebServlet(name = "UpdatePayment", urlPatterns = {"/UpdatePayment"})
public class UpdatePayment extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    // Retrieve the user ID from the session
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        System.out.print("ENTRO AL SERVLET");
        int paymentDetailsId = Integer.parseInt(request.getParameter("paymentDetailsIdUpdate"));
        String newCardNumber = request.getParameter("newCardNumber");
        String newFirstName = request.getParameter("newFirstName");
        String newLastName = request.getParameter("newLastName");
        String newExpiryDate = request.getParameter("newExpiryDate");
        int newCVV = Integer.parseInt(request.getParameter("newCVV"));
        System.out.print("ENTRO AL SERVLET"+paymentDetailsId);
        
        
        String query = "UPDATE IOTBAY.PaymentDetails SET ";

        if (!newCardNumber.isEmpty()) {
          query += "CARDNUMBER = '" + newCardNumber + "', ";
        }

        if (newCVV != 0) {
          query += "CVV = " + newCVV + ", ";
        }

        if (!newExpiryDate.isEmpty()) {
          query += "EXPIRYDATE = '" + newExpiryDate + "', ";
        }

        if (!newFirstName.isEmpty()) {
          query += "FIRSTNAME = '" + newFirstName + "', ";
        }

        if (!newLastName.isEmpty()) {
          query += "LASTNAME = '" + newLastName + "', ";
        }

        query = query.substring(0, query.length() - 2); // remove the last comma and space

        query += " WHERE PAYMENT_DETAILS_ID = " + paymentDetailsId;

        try {
            manager.updateCard(query);
            System.out.print("Succesfully Update card! check yo database");
            request.getRequestDispatcher("pay.jsp").forward(request,response);

        } catch (SQLException | NullPointerException ex) {
            System.out.println("Vague Exception Occured!");
        }

    }
}