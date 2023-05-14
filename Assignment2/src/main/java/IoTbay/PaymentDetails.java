/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IoTbay;

/**
 *
 * @author benja
 */
import java.sql.Date;

public class PaymentDetails {
    private int paymentDetailsId;
    private int userId;
    private String cardNumber;
    private int cvv;
    private String expiryDate;
    private String firstName;
    private String lastName;
    
    public PaymentDetails() {
    }
    
    public PaymentDetails(int paymentDetailsId, int userId, String cardNumber, int cvv, String expiryDate, String firstName, String lastName) {
        this.paymentDetailsId = paymentDetailsId;
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getPaymentDetailsId() {
        return paymentDetailsId;
    }

    public void setPaymentDetailsId(int paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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

