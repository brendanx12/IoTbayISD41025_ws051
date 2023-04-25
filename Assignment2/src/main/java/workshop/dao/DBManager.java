package workshop.dao;

/**
 *
 * @author Mushini
 */

//this class is going to contain the CRUD Operations.

import java.security.interfaces.RSAKey;
import workshop.student;
import java.sql.*;

public class DBManager {
    
    private Statement st;
   
public DBManager(Connection conn) throws SQLException {
    //according to the oracle docs, you need a connection object to create a Statement object
   st = conn.createStatement();   
}

//Find user by email and password in the database   
public student findStudent(String email) throws SQLException {  
    String query = "SELECT EMAIL FROM ROOT.STUDENTS WHERE EMAIL= '" + email + "'";
    ResultSet rs = st.executeQuery(query);
    
    while(rs.next()){
        String studentEmail = rs.getString(2);
        if (studentEmail.equals(email)){
            String studentName = rs.getString(1);
            return new student(studentName,"EMAIL","PASSWORD","TEST");
        }   
    }    
   return null;   
}

//Add a user-data into the database   
public void addStudent(String email, String name, String password, String DOB) throws SQLException {                   //code for add-operation       
  st.executeUpdate("sql query");   

}

//update a user details in the database   
public void updateStudent( String email, String name, String password, String gender, String favcol) throws SQLException {       
   //code for update-operation   

}       

//delete a user from the database   
public void deleteStudent(String email) throws SQLException{       
   //code for delete-operation   
}

}
