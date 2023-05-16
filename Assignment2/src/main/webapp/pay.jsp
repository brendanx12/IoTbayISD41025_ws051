<%--
Document : pay
Created on : May 9, 2023, 12:56:42 PM
Author : benja
--%>

<%@ page import="java.sql.*" %>
<%@page import="workshop.*"%>
<%@page import="IoTbay.*"%>
<%@page import="controller.*"%>
<%@ page import="workshop.dao.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page language="java" import="java.util.*" %>
<%@ page import="java.util.ArrayList" %>

<% 
    
    DBManager manager = (DBManager) session.getAttribute("manager");

%>
<!DOCTYPE html>
<html>
<head>
    <title>Payment Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/StyleSheetForNavBar.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%
        Customer loggedInCustomer = (Customer) session.getAttribute("Customer");
        String email = loggedInCustomer.getEmail();
        ResultSet newrs = manager.st.executeQuery("SELECT * FROM IOTBAY.CUSTOMER WHERE USEREMAIL = '" + email + "'");
        int userID = 0; // Declare the variable outside the if block

        if (newrs.next()) {
            userID = newrs.getInt(1); // Assign a value within the if block
        }
    %>

    <nav>
        <ul>
            <li><a href="mainPage.jsp">Home</a></li>
            <li><a href="LogOutController">Logout</a></li>
        </ul>
    </nav>
    <br>
    <br>
    <h1 align="center">IoT Bay Payment Page</h1>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <%
                        List<PaymentDetails> paymentDetailsList = new ArrayList<>();
                        ResultSet rs = manager.st.executeQuery("SELECT * FROM PaymentDetails WHERE userID = " + userID);
                        while (rs.next()) {
                            PaymentDetails paymentDetails = new PaymentDetails();
                            paymentDetails.setPaymentDetailsId(rs.getInt("PAYMENT_DETAILS_ID"));
                            paymentDetails.setUserId(rs.getInt("USERID"));
                            paymentDetails.setCardNumber(rs.getString("CARDNUMBER"));
                            paymentDetails.setFirstName(rs.getString("FIRSTNAME"));
                            paymentDetails.setExpiryDate(rs.getString("EXPIRYDATE"));
                            paymentDetailsList.add(paymentDetails);
                        }
                        %>
               

              <script>
                // get the dropdown element
                var dropdown = document.getElementById("selectedCard");

                // add event listener to the dropdown element
                dropdown.addEventListener("change", function() {
                  // get the selected value
                  var selectedValue = dropdown.value;

                  // set the value of the hidden input field
                  document.getElementById("paymentDetailsId").value = selectedValue;
                });
              </script>

            </div>

            <div class="col-md-6">
                <h3>Add a Payment Method:</h3>
                <form action="AddPaymentDetails" method="post">
                    <div class="form-group">
                        <label for="card_number">Card Number:</label>
                        <input type="text" class="form-control" id="card_number" name="card_number" maxlength="16"  required>
                    </div>
                    <div class="form-group">
                        <label for="card_holder_name">Card Holder Name:</label>
                        <input type="text" class="form-control" id="card_holder_name" name="card_holder_name" maxlength="50" required>
                    </div>
                    <div class="form-group">
                        <label for="card_holder_lastname">Card Holder Last Name:</label>
                        <input type="text" class="form-control" id="card_holder_lastname" name="card_holder_lastname" maxlength="50" required>
                    </div>
                    <div class="form-group">
                        <label for="card_CVV">Card CVV:</label>
                        <input type="number" class="form-control" id="card_CVV" name="card_CVV" maxlength="50" required>
                    </div>
                    <div class="form-group">
                        <label for="expiry_date">Expiry Date:</label>
                        <input type="text" class="form-control" id="expiry_date" name="expiry_date" required>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" value="Add Payment Method">
                    </div>
                    <input type="hidden" name="user_id" value="<%= userID %>">
                </form>
            </div>
                
                
            <div class="col-md-6">
                <h3>Delete a Payment Method:</h3>
                <form action="DeletePayment" method="post">
                    <div class="form-group">
                  <label for="payment_method">Payment Method:</label>
                  <select name="selectedCardDelete" id="selectedCardDelete">
                    <% for (PaymentDetails paymentDetails : paymentDetailsList) { %>
                    <option value="<%= paymentDetails.getPaymentDetailsId() %>">
                      <%= paymentDetails.getFirstName() %> - <%= paymentDetails.getCardNumber() %>
                    </option>
                    <% } %>
                  </select>
                  <input type="hidden" name="paymentDetailsIdDelete" id="paymentDetailsIdDelete" value="">
                </div>
                <div class="form-group">
                  <input type="submit" class="btn btn-primary" value="Delete">
                </div>
              </form>

              <script>
                // get the dropdown element
                var dropdown = document.getElementById("selectedCardDelete");

                // add event listener to the dropdown element
                dropdown.addEventListener("change", function() {
                  // get the selected value
                  var selectedValueDelete = dropdown.value;

                  // set the value of the hidden input field
                  document.getElementById("paymentDetailsIdDelete").value = selectedValueDelete;
                });
              </script>
            </div>
                  
                  
            <div class="col-md-6">
                <h3>Update a Payment Method:</h3>
                <form action="UpdatePayment" method="post">
                    <div class="form-group">
                  <label for="payment_method">Payment Method:</label>
                  <select name="selectedCardUpdate" id="selectedCardUpdate">
                    <% for (PaymentDetails paymentDetails : paymentDetailsList) { %>
                    <option value="<%= paymentDetails.getPaymentDetailsId() %>">
                      <%= paymentDetails.getFirstName() %> - <%= paymentDetails.getCardNumber() %>
                    </option>
                    <% } %>
                  </select>
                  <input type="hidden" name="paymentDetailsIdUpdate" id="paymentDetailsIdUpdate" value="">
                </div>
                  
                  <div class="form-group">
                    <label for="new_card_number">New Card Number:</label>
                    <input type="text" name="newCardNumber" id="newCardNumber" value="">
                  </div>
                  <div class="form-group">
                    <label for="new_cvv">New CVV:</label>
                    <input type="number" name="newCVV" id="newCVV" value="">
                  </div>
                  <div class="form-group">
                    <label for="new_expiry_date">New Expiry Date:</label>
                    <input type="text" name="newExpiryDate" id="newExpiryDate" value="">
                  </div>
                  <div class="form-group">
                    <label for="new_first_name">New First Name:</label>
                    <input type="text" name="newFirstName" id="newFirstName" value="">
                  </div>
                  <div class="form-group">
                    <label for="new_last_name">New Last Name:</label>
                    <input type="text" name="newLastName" id="newLastName" value="">
                  </div>
                  
                <div class="form-group">
                  <input type="submit" class="btn btn-primary" value="Update">
                </div>
              </form>

              <script>
                // get the dropdown element
                var dropdown = document.getElementById("selectedCardUpdate");

                // add event listener to the dropdown element
                dropdown.addEventListener("change", function() {
                  // get the selected value
                  var paymentValueUpdate = dropdown.value;

                  // set the value of the hidden input field
                  document.getElementById("paymentDetailsIdUpdate").value = paymentValueUpdate;
                });
              </script>
            </div>
                  
                  
        </div>
    </div>
</body>
</html>

