/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workshop.dao;
import java.sql.Connection;


/**
 *
 * @author Mushini
 */
public abstract class DB {
    protected String URL = "jdbc:derby://localhost:1527/IoTbayDB";//replace this string with your jdbc:derby local host url   
    
    protected String dbuser = "iotbay";//db root user   
    protected String dbpass = "1234"; //db root password   
    protected String driver = "org.apache.derby.jdbc.ClientDriver"; //jdbc client driver - built in with NetBeans 
    //this is the name of the connection to the database
    protected Connection conn; //connection null-instance to be initialized in sub-classes

}

