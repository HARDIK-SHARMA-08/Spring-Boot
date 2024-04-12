package com.example.rest_database.students;

import com.example.rest_database.school.School;
import com.example.rest_database.studentProfile.StudentPorfile;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student") // If Table is not defined it will create a table with pulic class name
public class Students {

    // Sets the id as Primary Key
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "fName", length = 20)
    private String firstname;

    @Column(name = "lName", length = 20)
    private String lastname;
    // Column Anotation can set the name/length of the Column and can set it Unique
    // & Upgradeable as well
    @Column(unique = true)
    private String email;
    private int age;

    @OneToOne(mappedBy = "student",
            // This Cascade all will delete all the StudentProfile Mapped by student if that
            // student is deleted
            cascade = CascadeType.ALL)
    private StudentPorfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    // Prevent from infinte loop
    @JsonBackReference
    private School school;

    public Students() {
    }

    // Getter
    public School getSchool() {
        return school;
    }

    public StudentPorfile getStudentProfile() {
        return studentProfile;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public Integer getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    // Setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String firstname) {
        this.firstname = firstname;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLast_name(String lastname) {
        this.lastname = lastname;
    }

    public void setStudentProfile(StudentPorfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
