package com.example.rest_database.school;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolResponse createSchool(@RequestBody School school) {
        return this.schoolService.createSchool(school);
    }

    @GetMapping("/schools")
    public List<SchoolResponse> getSchools() {
        return schoolService.getSchools();
    }

}
