package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Connection;
import workshop.dao.*;
/**
 *
 * @author Mushini
 */
@WebServlet(name = "ConnServletIotBay", urlPatterns = {"/ConnServletIotBay"})
public class ConnServletIotBay extends HttpServlet {
       private DBConnector db;
       private DBManager manager;
       private Connection conn;

       @Override //Create and instance of DBConnector for the deployment session
       public void init() {
           try {
               db = new DBConnector();
           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(ConnServletIotBay.class.getName()).log(Level.SEVERE, null, ex);
           }      
       }
       //doGet() is a method that processes any HTTP get requests that are sent into the servlet
       @Override //Add the DBConnector, DBManager, Connection instances to the session
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8"); 
           //"session" is a HttpSession created by the webserver. It is done in the request i think idk
           //all i know is it is created when someone launches this servlets
           //return the current session associated with this request.
           //and if a session is not created already, one will be created
           HttpSession session = request.getSession();
           conn = db.openConnection();   
           //throughout the session, this one connection is used.
           try {
               manager = new DBManager(conn);
           } catch (SQLException ex) {
               Logger.getLogger(ConnServletIotBay.class.getName()).log(Level.SEVERE, null, ex);
           }
           //export the DB manager to the view-session (JSPs)
           //setting the manager instance object to the session that is created.
           session.setAttribute("manager", manager);           
       }    
       @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)
        public void destroy() {
           try {
               db.closeConnection();
           } catch (SQLException ex) {
               Logger.getLogger(ConnServletIotBay.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }