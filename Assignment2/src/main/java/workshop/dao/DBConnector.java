package workshop.dao;

/**
 *
 * @author Mushini
 */
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;


public class DBConnector extends DB{
    //this is the DBConnector constructor
    //apparently it creates a connection with the database using the 
    //variables we declared in the superclass
    public DBConnector() throws ClassNotFoundException, SQLException {

        Class.forName(driver);

        conn = DriverManager.getConnection(URL, dbuser, dbpass);

}

 
//returns a connection instance hwich will be used in the class called DBManager to run SQL queries
public Connection openConnection(){

    return this.conn;

    }

 
//so this closes the connection after executing queries
public void closeConnection() throws SQLException {

    this.conn.close();

    }
}
