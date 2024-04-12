package com.example.rest_database.students;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

// Request Body with DTO(Data Transfer Object) or Record
// {
//     "firstname": "ravi",
//     "lastname": "Sharma",
//     "email": "ravsharma@gmail.com",
//     "age": 20,
//     "schoolId": 1
// }

public record StudentsDTO(
        @NotEmpty(message = "Firstname should not be empty")
        String firstname,

        String lastname,

        @NotEmpty
        @Email(message = "Please enter a valid Email Address")
        String email,

        @Positive
        int age,
        Integer schoolId) {
}
