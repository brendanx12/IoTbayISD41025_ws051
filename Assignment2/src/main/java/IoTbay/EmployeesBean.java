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
    private int StaffID;
    private String StaffFirstName;
    private String StaffMiddleName;
    private String StaffLastName;
    private String StaffEmail;
    private int StaffMobileNumber;
    private String StaffAddress;
    private String StaffState;
    private String StaffCity;
    private int StaffPostcode;
    private String StaffPassword;
    private boolean StaffActive;

    public EmployeesBean(int StaffID, String StaffFirstName, String StaffMiddleName, String StaffLastName, String StaffEmail, int StaffMobileNumber, String StaffAddress, String StaffState, String StaffCity, int StaffPostcode, String StaffPassword, boolean StaffActive) {
        this.StaffID = StaffID;
        this.StaffFirstName = StaffFirstName;
        this.StaffMiddleName = StaffMiddleName;
        this.StaffLastName = StaffLastName;
        this.StaffEmail = StaffEmail;
        this.StaffMobileNumber = StaffMobileNumber;
        this.StaffAddress = StaffAddress;
        this.StaffState = StaffState;
        this.StaffCity = StaffCity;
        this.StaffPostcode = StaffPostcode;
        this.StaffPassword = StaffPassword;
        this.StaffActive = StaffActive;
    }

    public int getStaffID() {
        return StaffID;
    }

    public void setStaffID(int StaffID) {
        this.StaffID = StaffID;
    }

    public String getStaffFirstName() {
        return StaffFirstName;
    }

    public void setStaffFirstName(String StaffFirstName) {
        this.StaffFirstName = StaffFirstName;
    }

    public String getStaffMiddleName() {
        return StaffMiddleName;
    }

    public void setStaffMiddleName(String StaffMiddleName) {
        this.StaffMiddleName = StaffMiddleName;
    }

    public String getStaffLastName() {
        return StaffLastName;
    }

    public void setStaffLastName(String StaffLastName) {
        this.StaffLastName = StaffLastName;
    }

    public String getStaffEmail() {
        return StaffEmail;
    }

    public void setStaffEmail(String StaffEmail) {
        this.StaffEmail = StaffEmail;
    }

    public int getStaffMobileNumber() {
        return StaffMobileNumber;
    }

    public void setStaffMobileNumber(int StaffMobileNumber) {
        this.StaffMobileNumber = StaffMobileNumber;
    }

    public String getStaffAddress() {
        return StaffAddress;
    }

    public void setStaffAddress(String StaffAddress) {
        this.StaffAddress = StaffAddress;
    }

    public String getStaffState() {
        return StaffState;
    }

    public void setStaffState(String StaffState) {
        this.StaffState = StaffState;
    }

    public String getStaffCity() {
        return StaffCity;
    }

    public void setStaffCity(String StaffCity) {
        this.StaffCity = StaffCity;
    }

    public int getStaffPostcode() {
        return StaffPostcode;
    }

    public void setStaffPostcode(int StaffPostcode) {
        this.StaffPostcode = StaffPostcode;
    }

    public String getStaffPassword() {
        return StaffPassword;
    }

    public void setStaffPassword(String StaffPassword) {
        this.StaffPassword = StaffPassword;
    }

    public boolean isStaffActive() {
        return StaffActive;
    }

    public void setStaffActive(boolean StaffActive) {
        this.StaffActive = StaffActive;
    }


    
}