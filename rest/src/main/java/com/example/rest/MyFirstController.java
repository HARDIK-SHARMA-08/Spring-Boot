package com.example.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {
    // Simple GET Method
    @GetMapping("/get")
    public String getRequest() {
        return "Hello from GET method";
    }

    // Request Body is a message
    @PostMapping("/post")
    public String postRequest(
            @RequestBody String message) {
        return "Hello from POST method: " + message;
    }

    // Request Body is an Object
    @PostMapping("/post-order")
    public String postRequestOrder(
            @RequestBody Order order) {
        return "Hello from POST method: " + order;
    }

    // Request Body is an Record
    @PostMapping("/post-order-record")
    public String postRequestOrderRecord(
            @RequestBody OrderRecord order) {
        return "Hello from POST method: " + order.toString();
    }

    // Using of Params
    // http:localhost:8080/get/Hardik
    @GetMapping("/get/{userName}")
    public String getParams(
            // @PathVariable Used from extracting values from URL
            @PathVariable String userName) {
        return "Hello from GET method: " + userName;
    }

    // Using of Params
    // http:localhost:8080/getParams?user_name=Hardik&age=22
    @GetMapping("/getParams")
    public String getRequestParams(
            // @RequestParam Used from extracting query parameter from URL
            @RequestParam String user_name,
            @RequestParam int age) {
        return "GET method: " + " Hello: " + user_name + " Age: " + age;
    }

    @PutMapping("/put")
    public String putRequest() {
        return "Hello from PUT method";
    }

    @DeleteMapping("/delete")
    public String deleteRequest() {
        return "Hello from DELETE method";
    }
}
