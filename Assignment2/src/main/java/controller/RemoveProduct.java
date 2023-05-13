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
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import workshop.dao.*;

/**
 *
 * @author brend
 */
@WebServlet(name = "RemoveProduct", urlPatterns = {"/RemoveProduct"})
public class RemoveProduct extends HttpServlet {

    private DBConnector Connector;
    private DBProduct manager;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //catch exceptions for DBConnector
        try{
            Connector = new DBConnector();
        }
        catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(RemoveProduct.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //catch the exceptions for DBProductManager
        try
        {
            manager = new DBProduct((Connector.openConnection()));
        }
        catch (SQLException ex){
            java.util.logging.Logger.getLogger(RemoveProduct.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //session
        HttpSession session = request.getSession();
        
        //Retrieve the inputted values from the user
        String name = request.getParameter("name");
       
        try{
            Boolean exists = manager.checkProduct(name);
            
            if(exists){
                //session.setAttribute("product", manager.getProductById(name));
                int id = manager.getProductById(name);
                manager.removeProductById(id);
                session.setAttribute("removed", "Product has been removed"); //Successfully Removed

                request.getRequestDispatcher("ProductRemovalSuccessfulMessage.jsp").include(request, response);
                response.sendRedirect("ProductRemovalSuccessfulMessage.jsp"); //Redirects user back to this page with a success message
            }
            else{
                session.setAttribute("removed", "Product has not been removed"); //Successfully updated
                request.getRequestDispatcher("ProductRemovalNotSuccessfulMessage.jsp").include(request, response);
                response.sendRedirect("ProductRemovalNotSuccessfulMessage.jsp"); //Redirects user back to this page with an error message
            }
            } catch(SQLException ex){
                System.out.println(ex.getErrorCode()+ " and " + ex.getMessage());//SQL error message is printed
            }
    }

}
