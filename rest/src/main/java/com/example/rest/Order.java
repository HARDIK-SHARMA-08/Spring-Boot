package com.example.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    // Json Property is the JSON name of the variable
    @JsonProperty("c-name")
    public String customerName;

    // Json Property is the JSON name of the variable
    @JsonProperty("p-name")
    public String productName;
    
    public int quantity;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Order -> " +
                " Customer Name: " + customerName +
                " Product Name: " + productName +
                " Quantity: " + quantity;
    }

}
