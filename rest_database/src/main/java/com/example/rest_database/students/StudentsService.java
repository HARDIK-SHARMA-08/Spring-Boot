package com.example.rest_database.students;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class StudentsService {
    private final StudentsRepository repository;
    private final StudentsMapper studentsMapper;

    public StudentsService(StudentsRepository repository, StudentsMapper studentsMapper) {
        this.repository = repository;
        this.studentsMapper = studentsMapper;
    }

    public StudentsResponse createStudents(
            StudentsDTO studentdto) {
        var student = studentsMapper.toStudent(studentdto);
        var savedStudent = repository.save(student);
        return studentsMapper.toStudentResponse(savedStudent);
    }

    public List<StudentsResponse> findAllStudents() {
        return repository.findAll()
                .stream()
                .map(studentsMapper::toStudentResponse)
                .collect(Collectors.toList());
    }

    public Students findAllStudentsById(
            Integer id) {
        return repository.findById(id)
                .orElse(new Students());
    }

    public List<Students> findAllStudentsByFirstName(
            String name) {
        return repository.findAllByFirstnameContaining(name);
    }

    public void deleteStudentByID(
            Integer id) {
        repository.deleteById(id);
    }
}
