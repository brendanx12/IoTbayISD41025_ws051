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
public class EmployeesBean implements Serializable{
    private String firstName;
    private String lastName;


    public EmployeesBean(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        
    }

    public EmployeesBean() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    
}