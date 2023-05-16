package controller;

/**
 *
 * @author Mushini
 */

import java.sql.*;
import workshop.dao.*;
import workshop.*;
import java.util.*;
import IoTbay.*;


import java.util.logging.*;

public class testDB {
    //scanner instance is for user input
    private static Scanner in = new Scanner(System.in);

 

public static void main(String[] args) {
    
 

try {
    
    //connector for database connection
    DBConnector connector = new DBConnector();
    Connection conn = connector.openConnection();
    //manager for the sql operations
    DBManager db = new DBManager(conn);
    DBProduct db2 = new DBProduct(conn);

    //System.out.print("User email: ");

    //String email = in.nextLine();
    //db.createTimeStampLogout(email);
    //then we're gonna run the search with email function
   // Customer newCustomer = db.findCustomer(email);
    //System.out.print("This email belongs to " + newCustomer.getFirstName());
    //System.out.print("Password is  " + newCustomer.getPassword());
    //System.out.print("He lives in the state  ");
    //db2.removeProductById(3);
    int id = db2.getProductById("name");
    db2.updateProduct(id, "Nadnerb", "Des", "type", 43, 5, "Image");
    //db2.removeProductByName("Nadnerb");
    //db2.getProductById("Nadnerb");
    //System.out.println(db2.getProductById("Nadnerb"));
    connector.closeConnection();

 

} catch (ClassNotFoundException | SQLException ex) {

    Logger.getLogger(testDB.class.getName()).log(Level.SEVERE, null, ex);

}

}
}
