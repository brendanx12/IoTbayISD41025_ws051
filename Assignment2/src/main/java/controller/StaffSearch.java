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
import java.util.List; 

/**
 *
 * @author brend
 */
@WebServlet(name = "StaffSearch", urlPatterns = {"/StaffSearch"})
public class StaffSearch extends HttpServlet {

    private DBConnector Connector;
    private DBProduct manager; 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            Connector = new DBConnector();
        }
        catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(StaffSearch.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //catch the exceptions for DBProductManager
        try{
            manager = new DBProduct((Connector.openConnection()));
        }
        catch (SQLException ex){
            java.util.logging.Logger.getLogger(StaffSearch.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //session
        HttpSession session = request.getSession();
        
        String keyword = request.getParameter("keyword");
        String searchType = request.getParameter("searchType");
        
        try{
            List<Product>productList;
            
            if(searchType.equals("name")){
                
                productList = manager.searchProductsByName(keyword);
                //session.setAttribute("productList", productList); //Successfully updated
            }
            else{
                productList = manager.searchProductsByType(keyword);
               
            }
             session.setAttribute("productList", productList); //Successfully updated
            request.getRequestDispatcher("StaffProductSearch.jsp").include(request, response);
        }  catch (SQLException ex) {
            Logger.getLogger(StaffSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
