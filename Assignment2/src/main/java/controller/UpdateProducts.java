/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
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
import IoTbay.Product;


/**
 *
 * @author brend
 */
@WebServlet(name = "UpdateProducts", urlPatterns = {"/UpdateProducts"})
public class UpdateProducts extends HttpServlet {

    private DBConnector Connector;
    private DBProduct manager;
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //doPost(request, response);
        
        //catch exceptions for DBConnector
        try{
            Connector = new DBConnector();
        }
        catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(SearchProduct.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //catch the exceptions for DBProductManager
        try{
            manager = new DBProduct((Connector.openConnection()));
        }
        catch (SQLException ex){
            java.util.logging.Logger.getLogger(SearchProduct.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //session
        HttpSession session = request.getSession();
        
        Product product = (Product) session.getAttribute("Product");
        //Retrieve the inputted values from the user
        //String previousName = request.getParameter("previousName");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description"); 
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String image = request.getParameter("image");
        
        try {
            // Call the method to update the product record
            manager.updateProduct(id, name, description, type, price, stock, image);
            
            // Redirect the user to a success page
            response.sendRedirect("UpdateSuccessful.jsp");
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(SearchProduct.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
