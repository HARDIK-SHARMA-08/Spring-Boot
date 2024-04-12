package com.example.rest_database.students;

import org.springframework.stereotype.Service;

import com.example.rest_database.school.School;

@Service
public class StudentsMapper {
    public Students toStudent(StudentsDTO studentdto) {
        var student = new Students();
        student.setFirst_name(studentdto.firstname());
        student.setLast_name(studentdto.lastname());
        student.setEmail(studentdto.email());
        student.setAge(studentdto.age());

        var school = new School();
        school.setId(studentdto.schoolId());

        student.setSchool(school);
        return student;
    }

    public StudentsResponse toStudentResponse(Students student) {
        return new StudentsResponse(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail());
    }
}
