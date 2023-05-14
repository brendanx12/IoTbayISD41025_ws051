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
@WebServlet(name = "DeletePayment", urlPatterns = {"/DeletePayment"})
public class DeletePayment extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    // Retrieve the user ID from the session
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        System.out.print("ENTRO AL SERVLET");
        int paymentDetailsId = Integer.parseInt(request.getParameter("paymentDetailsIdDelete"));
        System.out.print("ENTRO AL SERVLET"+paymentDetailsId);
        try {
            manager.deleteCard(paymentDetailsId);
            System.out.print("Succesfully deleted card! check yo database");
            request.getRequestDispatcher("pay.jsp").forward(request,response);

        } catch (SQLException | NullPointerException ex) {
            System.out.println("Vague Exception Occured!");
        }

    }
}