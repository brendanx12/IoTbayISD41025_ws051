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
 * @author brend
 */
@WebServlet(name = "SearchProduct", urlPatterns = {"/SearchProduct"})
public class SearchProduct extends HttpServlet {
    
    private DBConnector Connector;
    private DBProduct manager; 
    
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        
        session.setAttribute("product", null);
        session.setAttribute("found", null);
        
        String name = request.getParameter("name");
        
        try{
            boolean check = manager.checkProduct(name);
            if(check){
                Product product = manager.getProduct(name);
                session.setAttribute("product", product);
                request.getRequestDispatcher("ProductSearchPage.jsp").include(request, response);
                response.sendRedirect("ProductSearchPage.jsp"); //Redirects user back to this page with a success message
            }
            else{
                session.setAttribute("found", "Product was not found"); //Successfully updated
                request.getRequestDispatcher("ProductSearchPage.jsp").include(request, response);
                response.sendRedirect("ProductSearchPage.jsp"); //Redirects user back to this page with an error message
            }    
        } catch(SQLException ex){
            Logger.getLogger(SearchProduct.class.getName()).log(Level.SEVERE, null, ex);;//SQL error message is printed
        }
     }
}
