/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.PrintWriter;
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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shivali
 */
@WebServlet(name = "ListCustomerRecords", urlPatterns = {"/ListCustomerRecords"})
public class ListCustomerRecords extends HttpServlet {

        private DBConnector Connector;
        private DBManager manager;
        
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //doPost(request, response);
        //catch exceptions for DBConnector
        try {
        Connector = new DBConnector();
        }
        catch (ClassNotFoundException | SQLException ex){
        java.util.logging.Logger.getLogger(ListCustomerRecords.class.getName()).log(Level.SEVERE,null,ex);
        }

        //catch the exceptions for DB
        try{
        manager = new DBManager((Connector.openConnection()));
        }
        catch (SQLException ex){
            java.util.logging.Logger.getLogger(ListCustomerRecords.class.getName()).log(Level.SEVERE,null,ex);
        }

        //session
        HttpSession session = request.getSession();

        try{
            ArrayList<Customer> customers = manager.getAllCustomerData();
            
            session.setAttribute("customers", customers);
            request.getRequestDispatcher("CustomerRecords.jsp").include(request, response);
            session.setAttribute("show", "Customer Records");
            response.sendRedirect("CustomerRecords.jsp");
        
        if(customers != null){
            session.setAttribute("customers", customers);
            request.getRequestDispatcher("CustomerRecords.jsp").include(request, response);
            session.setAttribute("show", "Customer Records");
            response.sendRedirect("CustomerRecords.jsp");
        }
        else{
            request.getRequestDispatcher("CustomerRecords.jsp").include(request, response);
            session.setAttribute("show", "Customer records does not exist");
            response.sendRedirect("CustomerRecords.jsp");
        }
        }catch(SQLException ex){
            Logger.getLogger(ListCustomerRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}