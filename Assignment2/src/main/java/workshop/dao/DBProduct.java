/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workshop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import IoTbay.Product;


/**
 *
 * @author Brendan Allen 12596805
 */
public class DBProduct{
    
    private Statement st;
    String query;
    private List<Product> productList;
    
    public DBProduct(Connection conn)throws SQLException{       
        st = conn.createStatement();   
    }    

    //This method will allow you to add a product record to the database
    public void addProduct(int id, String name, String description, String type, double price, int stock, String image) throws SQLException {
        query = "INSERT INTO IOTBAY.PRODUCT(PRODUCTID, PRODUCTNAME, PRODUCTDESCRIPTION, PRODUCTTYPE, PRODUCTPRICE, PRODUCTSTOCK, PRODUCTIMAGE)" + 
                "VALUES("+id+", '"+name+"', '"+description+"', '"+type+"', "+price+", "+stock+", '"+image+"')";
        
            st.executeUpdate(query);
            System.out.println("Successful");
    }
    
    //This method will allow you to update a record in the database
    public void updateProduct(int id, String name, String description, String type, double price, int stock, String image) throws SQLException{
        query = "UPDATE IOTBAY.PRODUCT SET PRODUCTID = ("+id+"), PRODUCTNAME = ('"+name+"'), PRODUCTDESCRIPTION = ('"+description+"'), PRODUCTTYPE = ('"+type+"'), PRODUCTPRICE = ("+price+"), PRODUCTSTOCK = ("+stock+"), PRODUCTIMAGE = ('"+image+"') WHERE PRODUCTID = ("+id+")"; 
        st.executeUpdate(query);
        
    }
    
    //This method will check the product records and confirm if the record matches
    public boolean checkProduct(String name) throws SQLException{
        query = "SELECT * FROM IOTBAY.PRODUCT WHERE PRODUCTNAME = '"+name+"'";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            
            String productName = rs.getString(2);
            
            if(productName.equals(name)){
                return true;
            }
        }
        return false;
    }

    //This method removes a product record
    public void removeProductById(int id) throws SQLException{
        query = "DELETE FROM IOTBAY.PRODUCT " + "WHERE PRODUCTID = " + id;
            st.executeUpdate(query);
       
    }

    
    public String getProductByName(String name) throws SQLException{
        query = "SELECT PRODUCTNAME FROM IOTBAY.PRODUCT WHERE PRODUCTNAME = '"+name+"'";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            name = rs.getString(name);
        }
        return name;
    }

    

    //This method returns the product id by by using the query: 
    //""SELECT PRODUCTID FROM IOTBAY.PRODUCT WHERE PRODUCTNAME = '"+name+"'";"
    public int getProductById(String name) throws SQLException{
        query = "SELECT PRODUCTID FROM IOTBAY.PRODUCT WHERE PRODUCTNAME = '"+name+"'";
        ResultSet rs = st.executeQuery(query);
        
        int productID = 0;
        
        while(rs.next()){
        productID = rs.getInt(1);
        }
        return productID;
    }
    
    
    //Find the product where PRODUCTNAME in the database equals name, and return it if it exists
    public Product getProduct(String name) throws SQLException{
        query = "SELECT * FROM IOTBAY.PRODUCT WHERE PRODUCTNAME = '"+name+"'";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            name = rs.getString(2);
            
            if(name.equals(name)){
                int id = rs.getInt(1);
                String description = rs.getString(3);
                String type = rs.getString(4);
                double price = rs.getDouble(5);
                int stock = rs.getInt(6);
                String image = rs.getString(7);
                return new Product(id, name, description, type, price, stock, image);
            }
        }
        return null;
    }
    

    //Gets all products from the database and adds them to the list.
    public ArrayList<Product> getAllProducts() throws SQLException{
        ArrayList<Product> products = new ArrayList<>();
        //query = "SELECT * FROM IOTBAY.PRODUCT";
        query = "SELECT * FROM IOTBAY.PRODUCT";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
             int id = rs.getInt(1);
             String name = rs.getString(2);
             String description = rs.getString(3);
             String type = rs.getString(4);
             double price = rs.getDouble(5);
             int stock = rs.getInt(6);
             String image = rs.getString(7);
             
             products.add(new Product(id, name, description, type, price, stock, image));
        }
                return products;
    }

    //Gets all products by name from the database and adds them to the list.
    public List<Product> searchProductsByName(String name)throws SQLException{
        List<Product> searchResults = new ArrayList<>();
        query = "SELECT * FROM IOTBAY.PRODUCT WHERE PRODUCTNAME = '"+name+"'";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
             int id = rs.getInt(1);
             String retrievedName = rs.getString(2);
             String description = rs.getString(3);
             String retrievedType = rs.getString(4);
             double price = rs.getDouble(5);
             int stock = rs.getInt(6);
             String image = rs.getString(7);
             
             Product product = new Product(id, retrievedName, description, retrievedType, price, stock, image);
             searchResults.add(product);
        }
        
        return searchResults;
    }
    
     //Gets all products by type from the database and adds them to the list.
    public List<Product> searchProductsByType(String type)throws SQLException{
        List<Product> searchResults = new ArrayList<>();
        query = "SELECT * FROM IOTBAY.PRODUCT WHERE PRODUCTTYPE = '"+type+"'";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
             int id = rs.getInt(1);
             String name = rs.getString(2);
             String description = rs.getString(3);
             String retrievedType = rs.getString(4);
             double price = rs.getDouble(5);
             int stock = rs.getInt(6);
             String image = rs.getString(7);
             
             Product product = new Product(id, name, description, retrievedType, price, stock, image);
             searchResults.add(product);
        }
        
        return searchResults;
    }
}
