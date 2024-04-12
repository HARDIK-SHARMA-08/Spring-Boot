package com.example.rest_database.school;

import java.util.List;

import com.example.rest_database.students.Students;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class School {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(
        mappedBy = "school"
    )
    //Prevents from infinte Loop
    @JsonManagedReference
    private List<Students> student;

    public School() {

    }

    public School(String name) {
        this.name = name;
    }

    public void setStudent(List<Students> student){
        this.student = student;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public List<Students> getStudent(){
        return student;
    }

    public String getName(){
        return name;
    }

    public Integer getId(){
        return id;
    }
}
