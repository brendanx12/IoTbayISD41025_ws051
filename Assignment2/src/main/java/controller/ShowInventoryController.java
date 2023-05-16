/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import workshop.dao.DBProduct;
import workshop.dao.DBConnector;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import IoTbay.Product;

/**
 *
 * @author brend
 */
@WebServlet(name = "ShowInventoryController", urlPatterns = {"/ShowInventoryController"})
public class ShowInventoryController extends HttpServlet {

    private DBConnector Connector;
    private DBProduct manager;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //catch exceptions for DBConnector
        try{
            Connector = new DBConnector();
        }
        catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //catch the exceptions for DBProductManager
        try{
            manager = new DBProduct((Connector.openConnection()));
        }
        catch (SQLException ex){
            java.util.logging.Logger.getLogger(ShowInventoryController.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //session
        HttpSession session = request.getSession();
        
        try{
            ArrayList<Product> products = manager.getAllProducts();
           
            if(products != null){
                session.setAttribute("products", products);
                request.getRequestDispatcher("ListOfProducts.jsp").include(request, response);
                session.setAttribute("show", "IoTBayInventory");
                response.sendRedirect("ListOfProducts.jsp");
            }
            else{
                request.getRequestDispatcher("ListOfProducts.jsp").include(request, response);
                session.setAttribute("show", "Inventory does not exist");
                response.sendRedirect("ListOfProducts.jsp");
            }
        }catch(SQLException ex){
            Logger.getLogger(ShowInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
