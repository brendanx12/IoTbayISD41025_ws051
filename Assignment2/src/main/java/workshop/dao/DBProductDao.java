///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */

package workshop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import IoTbay.*;
import java.util.*;

/**
 *
 * @author danielhoang
 */
public class DBProductDao {
    public Statement st;
    public String query;
    public ResultSet rs;
    
    
    public DBProductDao(Connection conn) throws SQLException {
    //according to the oracle docs, you need a connection object to create a Statement object
        st = conn.createStatement();
        
    }
    
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<Product>();
            
       
            query = "SELECT * FROM IOTBAY.PRODUCT";
            rs = st.executeQuery(query);
            while(rs.next())    {
                Product product = new Product();
                product.setID(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setType(rs.getString(4));
                product.setPrice(rs.getDouble(5));
                product.setStock(rs.getInt(6));
                product.setImage(rs.getString(7));
                
                products.add(product);
                }         
                  
  
       
        return products;
    }
    
    
    //...

    public Product getProductById(int productID) throws SQLException {
        System.out.print("enter function");
        //List<Product> cart = new ArrayList<Product>();
        Product product = null;
            query = "SELECT * FROM IOTBAY.PRODUCT WHERE PRODUCTID = " + productID;
            System.out.print("before query");
            rs = st.executeQuery(query);
            System.out.print("after query");


            if (rs.next()) {
                product = new Product();
                product.setID(rs.getInt("PRODUCTID"));
                product.setName(rs.getString("PRODUCTName"));
                product.setType(rs.getString("PRODUCTTYPE"));
                product.setPrice(rs.getDouble("PRODUCTPRICE"));
                product.setStock(rs.getInt("PRODUCTSTOCK"));
            }


        return product;
    }

    
    public void decreaseStock(int productID, int quantity) throws SQLException  {
        System.out.print("decreaseBefore");
        query = "UPDATE IOTBAY.PRODUCT SET PRODUCTSTOCK = PRODUCTSTOCK - " + quantity + "  WHERE PRODUCTID = " + productID;
        rs = st.executeQuery(query);
        System.out.print("decreaseAfter");
          
//query = "UPDATE PRODUCTS SET stock = stock - ? WHERE productID = ?";
//PreparedStatement statement = Connection conn.prepareStatement(query);
//statement.setInt(1, quantity);
//statement.setInt(2, productID);
//statement.executeUpdate();



        
    }
//...

    
    
    
}