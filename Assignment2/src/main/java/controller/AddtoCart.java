/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
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
 * @author danielhoang
 */
@WebServlet(name = "AddtoCart", urlPatterns = {"/AddtoCart"})
public class AddtoCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddtoCart</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddtoCart at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException  {
        //processRequest(request, response);
        
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();
       //DBConnection

        //get productID from request from JSP
     
        int productID = Integer.parseInt(request.getParameter("productID"));
        
        int quantity = 1;
        System.out.print(productID);
        
        //get cart from session if it exists, otherwise create one
         ArrayList<Product> cart = (ArrayList<Product>) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            request.getSession().setAttribute("cart", cart);
            System.out.print(cart);
        }
        
        try {
            DBConnector dbConnector = new DBConnector();
            Connection conn = dbConnector.openConnection();
            DBProductDao productDao = new DBProductDao(conn);
            
            

           
            System.out.print("before");
            Product product = productDao.getProductById(productID);
            System.out.print("after");

                // Add the product to the cart
                System.out.print(product.getStock());
                cart.add(product);
                //response.sendRedirect("cart.jsp");
                request.getRequestDispatcher("orderHomePage.jsp").forward(request,response);   
        }
        
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Vague Exception Occured!");
        }
        
    }
   }
