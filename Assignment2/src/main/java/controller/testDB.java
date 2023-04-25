package controller;

/**
 *
 * @author Mushini
 */

import java.sql.*;
import workshop.dao.*;
import workshop.*;
import java.util.*;

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

 

    System.out.print("User email: ");

    String email = in.nextLine();
    //then we're gonna run the search with email function
    student newStudent = db.findStudent(email);
    System.out.print("This email belongs to " + newStudent.getName());

    connector.closeConnection();

 

} catch (ClassNotFoundException | SQLException ex) {

    Logger.getLogger(testDB.class.getName()).log(Level.SEVERE, null, ex);

}

}
}
