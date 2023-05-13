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
import java.sql.Timestamp;
public class DBManager {
    
    public Statement st;
   
public DBManager(Connection conn) throws SQLException {
    //according to the oracle docs, you need a connection object to create a Statement object
   st = conn.createStatement();   
}

//Find user by email and password in the database   
//returns that customer
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
public void updateCustomer( String firstName,String middleName,String lastName, String email,
        int mobileNumber, String address,String state, String city,int postcode, String password)
        throws SQLException {       
            String query = "UPDATE CUSTOMER SET USERFIRSTNAME = '" + firstName + "'," + 
                    "SET USERMIDDLENAME = '" + middleName + "'," + "SET USERLASTNAME = '" + lastName + 
                    "'," + "SET USER MOBILENUMBER = " + mobileNumber + ",SET USERPASSWORD = '" + 
                    password + "'," + "SET USERADDRESS = '" + address + "'," + "SET USERCITY = '" + city + "',"
                    + "SET USERSTATE = '" + state+ "'," + "SET USERPOSTCODE = " + postcode + "WHERE USEREMAIL = '" + email +"'";
              
                    String query2 = "UPDATE CUSTOMER SET USERFIRSTNAME = '" + firstName + "' WHERE USEREMAIL = '" + email + "'";    
                    String query3 = "UPDATE CUSTOMER SET USERMIDDLENAME = '" + middleName + "' WHERE USEREMAIL = '" + email + "'";  
                    String query4 = "UPDATE CUSTOMER SET USERLASTNAME = '" + lastName + "' WHERE USEREMAIL = '" + email + "'";  
                    String query5 = "UPDATE CUSTOMER SET USERMOBILENUMBER = " + mobileNumber + " WHERE USEREMAIL = '" + email + "'"; 
                    String query6 = "UPDATE CUSTOMER SET USERPASSWORD = '" + password + "' WHERE USEREMAIL = '" + email + "'"; 
                    String query7 = "UPDATE CUSTOMER SET USERSTATE = '" + state + "' WHERE USEREMAIL = '" + email + "'"; 
                    String query8 = "UPDATE CUSTOMER SET USERCITY = '" + city + "' WHERE USEREMAIL = '" + email + "'";
                    String query9 = "UPDATE CUSTOMER SET USERPOSTCODE= " + postcode + " WHERE USEREMAIL = '" + email + "'"; 
                    String query10= "UPDATE CUSTOMER SET USERADDRESS= '" + address + "' WHERE USEREMAIL = '" + email + "'"; 
                    st.executeUpdate(query2);
                    st.executeUpdate(query3);
                    st.executeUpdate(query4);
                    st.executeUpdate(query5);
                    st.executeUpdate(query6);
                    st.executeUpdate(query7);
                    st.executeUpdate(query8);
                    st.executeUpdate(query9);
                    st.executeUpdate(query10);
                    

}       

//delete a user from the database   
public void deleteCustomer(String email) throws SQLException{       
   //code for delete-operation 
   String DeleteQuery = "DELETE FROM CUSTOMER WHERE USEREMAIL = '" + email + "'";
   st.executeUpdate(DeleteQuery);
}

public void createTimeStamp(String email) throws SQLException{
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
 
    String cat = "INSERT INTO IOTBAY.CUSTOMERACCESSLOGS(ACCESSEMAIL,ACCESSTYPE,ACCESSTIME) VALUES ('" + email + "'," + "'LOGIN', '" +timestamp + "')" ;
    st.executeUpdate(cat);
    System.out.println("Successfully added to database");
    
}

public void createTimeStampLogout(String email)throws SQLException{
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    String cat2 = "INSERT INTO IOTBAY.CUSTOMERACCESSLOGS(ACCESSEMAIL,ACCESSTYPE,ACCESSTIME) VALUES ('" + email + "'," + "'LOGOUT', '" +timestamp + "')" ;
    st.executeUpdate(cat2);
    System.out.println("Successfully added to database");
    
}

public Customer viewAccess(String email) throws SQLException {  
    //String query = "SELECT * FROM IOTBAY.CUSTOMER WHERE USEREMAIL= '" + email + "'";
    String accessQuery = "SELECT * FROM IOTBAY.CUSTOMERACCESSLOGS WHERE ACCESSEMAIL = '" + email + "'";
    //SELECT * FROM IOTBAY.CUSTOMER WHERE USERFIRSTNAME = 'John';
    ResultSet rs = st.executeQuery(accessQuery);
    System.out.println("<table border=1 width=50% height=50%>");  
    System.out.println("<tr><th>Email</th><th>Time Accessed</th><th>Access </th><tr>");  
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
        }   
    }    
   return null;   
}
//Add a user-data into the database   
public void addStaff(String firstName,String middleName,String lastName,String email,
        int mobileNumber, String address,String state, String city,int postcode, String password)
        throws SQLException{ 
    //code for add-operation       
    String query = "INSERT INTO IOTBAY.STAFF (STAFFFIRSTNAME, STAFFMIDDLENAME,STAFFLASTNAME,STAFFMOBILENUMBER,STAFFEMAIL,STAFFPASSWORD," +
"STAFFADDRESS,STAFFCITY,STAFFSTATE,STAFFPOSTCODE ) VALUES ('" + firstName + "'," + "'" + middleName + "'," + "'" + lastName + "'," + mobileNumber + "," + "'" + email + "'," + "'" + password + "'," + "'" + address + "'," + "'" + city + "',"
            + "'" + state + "'," + postcode +")";

    st.executeUpdate(query); 
    System.out.println("Success");
 

}

public Customer findStaff(String email, String InputtedPassword) throws SQLException {  
    String query = "SELECT * FROM IOTBAY.STAFF WHERE STAFFEMAIL= '" + email + "'";
    //SELECT * FROM IOTBAY.CUSTOMER WHERE USERFIRSTNAME = 'John';
    ResultSet rs = st.executeQuery(query);
    while(rs.next()){
        String customerEmail = rs.getString(5);
        if (customerEmail.equals(email)){
            String firstName  = rs.getString(1);
                String middleName = rs.getString(2);
                String lastName = rs.getString(3);
                int mobileNumber = rs.getInt(4);
                String password = rs.getString(6);
                String address = rs.getString(7);
                String city = rs.getString(8);
                String state = rs.getString(9);
                int postcode = rs.getInt(10);
                if(InputtedPassword.equals(rs.getString(6))){
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

public void deleteStaff(String email) throws SQLException{       
   //code for delete-operation 
   String DeleteQuery = "DELETE FROM IOTBAY.STAFF WHERE STAFFEMAIL = '" + email + "'";
   st.executeUpdate(DeleteQuery);
}
public void updateStaff( String firstName,String middleName,String lastName, String email,
        int mobileNumber, String address,String state, String city,int postcode, String password)
        throws SQLException {       
           
              
                    String query2 = "UPDATE IOTBAY.STAFF SET STAFFFIRSTNAME = '" + firstName + "' WHERE STAFFEMAIL = '" + email + "'";    
                    String query3 = "UPDATE IOTBAY.STAFF SET STAFFMIDDLENAME = '" + middleName + "' WHERE STAFFEMAIL = '" + email + "'";  
                    String query4 = "UPDATE IOTBAY.STAFF SET STAFFLASTNAME = '" + lastName + "' WHERE STAFFEMAIL = '" + email + "'";  
                    String query5 = "UPDATE IOTBAY.STAFF SET STAFFMOBILENUMBER = " + mobileNumber + " WHERE STAFFEMAIL = '" + email + "'"; 
                    String query6 = "UPDATE IOTBAY.STAFF SET STAFFPASSWORD = '" + password + "' WHERE STAFFEMAIL = '" + email + "'"; 
                    String query7 = "UPDATE IOTBAY.STAFF SET STAFFSTATE = '" + state + "' WHERE STAFFEMAIL = '" + email + "'"; 
                    String query8 = "UPDATE IOTBAY.STAFF SET STAFFCITY = '" + city + "' WHERE STAFFEMAIL = '" + email + "'";
                    String query9 = "UPDATE IOTBAY.STAFF SET STAFFPOSTCODE= " + postcode + " WHERE STAFFEMAIL = '" + email + "'"; 
                    String query10= "UPDATE IOTBAY.STAFF SET STAFFADDRESS= '" + address + "' WHERE STAFFEMAIL = '" + email + "'"; 
                    st.executeUpdate(query2);
                    st.executeUpdate(query3);
                    st.executeUpdate(query4);
                    st.executeUpdate(query5);
                    st.executeUpdate(query6);
                    st.executeUpdate(query7);
                    st.executeUpdate(query8);
                    st.executeUpdate(query9);
                    st.executeUpdate(query10);
                    

}   

public void addPerson(String firstName, String lastName) throws SQLException{       
   //code for delete-operation 
   String DeleteQuery = "INSERT INTO PEOPLE (FIRSTNAME, LASTNAME) VALUES ('" + firstName + "', '" + lastName + "')";
   st.executeUpdate(DeleteQuery);
}

public void createCustomer(String firstName,String middleName,String lastName,String email,
        int mobileNumber, String address,String state, String city,int postcode, String password)
        throws SQLException{ 
    //code for add-operation       
    String query = "INSERT INTO IOTBAY.CUSTOMER (USERFIRSTNAME, USERMIDDLENAME, USERLASTNAME,USERMOBILENUMBER,USEREMAIL,USERPASSWORD," +
"USERADDRESS,USERCITY,USERSTATE,USERPOSTCODE ) VALUES ('" + firstName + "'," + "'" + middleName + "'," + "'" + lastName + "'," + mobileNumber + "," + "'" + email + "'," + "'" + password + "'," + "'" + address + "'," + "'" + city + "',"
            + "'" + state + "'," + postcode +")";

    st.executeUpdate(query); 
    System.out.println("Success");
 

}

public void customerUpdate( String firstName,String middleName,String lastName, String email,
        int mobileNumber, String address,String state, String city,int postcode, String password)
        throws SQLException {       
            String query = "UPDATE CUSTOMER SET USERFIRSTNAME = '" + firstName + "'," + 
                    "SET USERMIDDLENAME = '" + middleName + "'," + "SET USERLASTNAME = '" + lastName + 
                    "'," + "SET USER MOBILENUMBER = " + mobileNumber + ",SET USERPASSWORD = '" + 
                    password + "'," + "SET USERADDRESS = '" + address + "'," + "SET USERCITY = '" + city + "',"
                    + "SET USERSTATE = '" + state+ "'," + "SET USERPOSTCODE = " + postcode + "WHERE USEREMAIL = '" + email +"'";
              
                    String query2 = "UPDATE CUSTOMER SET USERFIRSTNAME = '" + firstName + "' WHERE USEREMAIL = '" + email + "'";    
                    String query3 = "UPDATE CUSTOMER SET USERMIDDLENAME = '" + middleName + "' WHERE USEREMAIL = '" + email + "'";  
                    String query4 = "UPDATE CUSTOMER SET USERLASTNAME = '" + lastName + "' WHERE USEREMAIL = '" + email + "'";  
                    String query5 = "UPDATE CUSTOMER SET USERMOBILENUMBER = " + mobileNumber + " WHERE USEREMAIL = '" + email + "'"; 
                    String query6 = "UPDATE CUSTOMER SET USERPASSWORD = '" + password + "' WHERE USEREMAIL = '" + email + "'"; 
                    String query7 = "UPDATE CUSTOMER SET USERSTATE = '" + state + "' WHERE USEREMAIL = '" + email + "'"; 
                    String query8 = "UPDATE CUSTOMER SET USERCITY = '" + city + "' WHERE USEREMAIL = '" + email + "'";
                    String query9 = "UPDATE CUSTOMER SET USERPOSTCODE= " + postcode + " WHERE USEREMAIL = '" + email + "'"; 
                    String query10= "UPDATE CUSTOMER SET USERADDRESS= '" + address + "' WHERE USEREMAIL = '" + email + "'"; 
                    st.executeUpdate(query2);
                    st.executeUpdate(query3);
                    st.executeUpdate(query4);
                    st.executeUpdate(query5);
                    st.executeUpdate(query6);
                    st.executeUpdate(query7);
                    st.executeUpdate(query8);
                    st.executeUpdate(query9);
                    st.executeUpdate(query10);
                    

}       
}

