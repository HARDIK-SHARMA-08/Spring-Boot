package com.example.rest_database.students;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class StudentsController {

    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    // Request Body with DTO(Data Transfer Object) or Record
    // {
    // "firstname": "ravi",
    // "lastname": "Sharma",
    // "email": "ravsharma@gmail.com",
    // "age": 20,
    // "schoolId": 1
    // }

    @PostMapping("/students")
    public StudentsResponse createStudent(
            @Valid @RequestBody StudentsDTO studentdto) {
        return this.studentsService.createStudents(studentdto);
    }

    // Request Body with DTO(Data Transfer Object) or Record
    // {
    // "firstname": "ravi",
    // "lastname": "Sharma",
    // "email": "ravsharma@gmail.com",
    // "age": 20,
    // "school": {
    // "id" : 1
    // }
    // }

    // @PostMapping("/students")
    // public Student post(
    // @RequestBody Student student) {
    // return repository.save(student);
    // }

    @GetMapping("/students")
    public List<StudentsResponse> findAllStudents() {
        return studentsService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public Students findAllStudentsById(
            @PathVariable("student-id") Integer id) {
        return studentsService.findAllStudentsById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<Students> findAllStudentsByFirstName(
            @PathVariable("student-name") String name) {
        return studentsService.findAllStudentsByFirstName(name);
    }

    @DeleteMapping("/students/{student-id}")
    public void deleteStudentByID(
            @PathVariable("student-id") Integer id) {
        studentsService.deleteStudentByID(id);
    }

    //Exception Handling
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
