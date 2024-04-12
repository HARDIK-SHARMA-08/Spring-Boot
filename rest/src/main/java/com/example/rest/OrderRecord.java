package com.example.rest;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity) {

    // In this record we dont have to specify any setter and getter like we did in
    // class
    // Also no need to override the toString() function
}
