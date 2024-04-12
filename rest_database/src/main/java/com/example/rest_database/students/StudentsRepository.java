package com.example.rest_database.students;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
    List<Students> findAllByFirstnameContaining(String p);
    List<Students> findAllByLastnameContaining(String p);
    List<Students> findAllByEmailContaining(String p);

}
