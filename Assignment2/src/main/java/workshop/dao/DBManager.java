package workshop.dao;

/**
 *
 * @author Mushini
 */

//this class is going to contain the CRUD Operations.

import java.security.interfaces.RSAKey;
import workshop.student;
import java.sql.*;
import IoTbay.*;

public class DBManager {
    
    private Statement st;
   
public DBManager(Connection conn) throws SQLException {
    //according to the oracle docs, you need a connection object to create a Statement object
   st = conn.createStatement();   
}

//Find user by email and password in the database   
public Customer findCustomer(String email, String InputtedPassword) throws SQLException {  
    String query = "SELECT * FROM IOTBAY.CUSTOMER WHERE USEREMAIL= '" + email + "'";
    //SELECT * FROM IOTBAY.CUSTOMER WHERE USERFIRSTNAME = 'John';
    ResultSet rs = st.executeQuery(query);
    while(rs.next()){
        String customerEmail = rs.getString(6);
        if (customerEmail.equals(email)){
            String firstName  = rs.getString(2);
                String middleName = rs.getString(3);
                String lastName = rs.getString(4);
                int mobileNumber = rs.getInt(5);
                String password = rs.getString(7);
                String address = rs.getString(8);
                String city = rs.getString(9);
                String state = rs.getString(10);
                int postcode = rs.getInt(11);
                if(InputtedPassword.equals(rs.getString(7))){
                    return new Customer(firstName,middleName,lastName,customerEmail,mobileNumber,
            address, state,city,postcode,password);
                }else{
                    System.err.println("Incorrect Password");
                    return null;
                }
        }   
    }    
   return null;   
}

//Add a user-data into the database   
public void addCustomer(String firstName,String middleName,String lastName,String email,
        int mobileNumber, String address,String state, String city,int postcode, String password)
        throws SQLException{ 
    //code for add-operation       
    String query = "INSERT INTO IOTBAY.CUSTOMER (USERFIRSTNAME, USERMIDDLENAME, USERLASTNAME,USERMOBILENUMBER,USEREMAIL,USERPASSWORD," +
"USERADDRESS,USERCITY,USERSTATE,USERPOSTCODE ) VALUES ('" + firstName + "'," + "'" + middleName + "'," + "'" + lastName + "'," + mobileNumber + "," + "'" + email + "'," + "'" + password + "'," + "'" + address + "'," + "'" + city + "',"
            + "'" + state + "'," + postcode +")";

    st.executeUpdate(query); 
    System.out.println("Success");
 

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
