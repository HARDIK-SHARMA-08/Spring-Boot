package com.example.rest_database.school;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    private final SchoolRepository repository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository repository, SchoolMapper schoolMapper) {
        this.repository = repository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolResponse createSchool(School school) {
        var savedSchool = repository.save(school);
        return schoolMapper.toSchoolResponse(savedSchool);
    }

    public List<SchoolResponse> getSchools() {
        // Retrieve all schools from the repository
        return repository.findAll()
                // Convert the collection to a stream for processing
                .stream()
                // Map each School object to its corresponding SchoolResponse object
                .map(schoolMapper::toSchoolResponse)
                // Collect the mapped SchoolResponse objects into a List
                .collect(Collectors.toList());
    }
}
