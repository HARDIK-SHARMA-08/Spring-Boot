package com.example.rest_database.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public SchoolResponse toSchoolResponse(School school) {
        return new SchoolResponse(school.getName());
    }
}
