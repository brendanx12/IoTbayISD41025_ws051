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


 /*
 * @author brend
 */
@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})
public class AddProduct extends HttpServlet {

    private DBConnector Connector;
    private DBProduct manager;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
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
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //session
        HttpSession session = request.getSession();

        //Collected parameters from the ProductForm.jsp
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description"); 
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String image = request.getParameter("image");
        
       
        
        try{
            if(name != null){
                manager.addProduct(id, name, description, type, price, stock, image);//call the addProduct
                session.setAttribute("added", "Product has been added to the inventory");
                
                request.getRequestDispatcher("ProductForm.jsp").include(request, response); //request comes from the addNewItem.jsp
                response.sendRedirect("ProductForm.jsp"); //the user is redirected back to this page with the success message
            }
            else{
                session.setAttribute("added","product hasn't been added to the inventory");
                request.getRequestDispatcher("ProductForm.jsp").include(request, response);
            } 
        } 
        catch(SQLException | NullPointerException ex){
             Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex); //if there is an SQL error, it is logged under this Servlet
             //id, name, description, type, price, stock, images
        }
        
        
    }
}
