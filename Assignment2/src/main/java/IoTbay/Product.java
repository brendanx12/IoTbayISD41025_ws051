/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IoTbay;

import java.io.Serializable;

/**
 *
 * @author brend
 */
public class Product implements Serializable{
    private int id;
    private String name;
    private String description;
    private String type;
    private double price;
    private int stock;
    private String image;
    
    public Product(int id, String name, String description, String type, double price, int stock, String image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        this.stock = stock;
        this.image = image;
    }
    
    public int getID(){
        return id;
    }
    
     public void setID(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    public String getImage(){
        return image;
    }
    
    public void setImage(String image)
    {
        this.image = image;
    }
}