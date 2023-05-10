
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
 * @author Mushini
 */
@WebServlet(name = "StaffRegisterIotBay", urlPatterns = {"/StaffRegisterIotBay"})
public class StaffRegisterIotBay extends HttpServlet {
    
    //basic required code for servlets
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    HttpSession session = request.getSession();
    DBManager manager = (DBManager) session.getAttribute("manager");
    Customer newCustomer = null;
    
    String firstName = request.getParameter("firstName");
    String middleName= request.getParameter("middleName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    int mobileNumber = Integer.parseInt(request.getParameter("mobileNumber"));
    String address = request.getParameter("address");
    String state = request.getParameter("state");
    String city = request.getParameter("city");
    int postcode = Integer.parseInt(request.getParameter("postcode"));
    String password = request.getParameter("password");
    
    
    
    //now we're gonna do the DBManager fucntions that I created to register a user
    //we need to check if the user email is already int he databaase
    //if it isnt then we can register with that email
    try {
    //then we're gonna run the search with email function
    manager.addStaff(firstName, middleName,lastName,email,mobileNumber,address,state,city,postcode,password);
    System.out.print("Succesfully added boy! check yo database");
    session.setAttribute("newCustomer",firstName);
    request.getRequestDispatcher("welcome.jsp").forward(request,response);
} catch (SQLException | NullPointerException ex) {
    System.out.println("Vague Exception Occured!");
}
          
          
    
                      
        }  
}
