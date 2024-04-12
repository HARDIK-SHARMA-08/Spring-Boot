package com.example.rest_database.studentProfile;

import com.example.rest_database.students.Students;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class StudentPorfile {
    @Id
    @GeneratedValue
    private Integer id;
    private String about;

    @OneToOne
    @JoinColumn(
        // student_id will be the Foreign Key
        // Foreign Key is the Primary key of Another Table that is in this Case
        // student_id is the Foreign Key and it is Primary Key of Student Table
        name = "student_id"
    )
    private Students student;

    public StudentPorfile() {
    }

    public StudentPorfile(String about) {
        this.about = about;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public Integer getId() {
        return id;
    }

}
