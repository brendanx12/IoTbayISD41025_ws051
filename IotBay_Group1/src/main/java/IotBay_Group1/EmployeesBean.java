package IotBay_Group1;

import java.io.Serializable;

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
