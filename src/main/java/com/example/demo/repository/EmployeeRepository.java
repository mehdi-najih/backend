package com.example.demo.repository;

import com.example.demo.entity.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //Filtring
    @Query("SELECT u FROM Employee u WHERE" +
            " (:firstName IS NULL OR u.firstName = :firstName) and (:lastName IS NULL OR u.lastName = :lastName)" +
            "and (:emailId IS NULL OR u.emailId = :emailId)")
    Page<Employee> getEmployees(
            @Param("firstName") String firstName , @Param("lastName") String lastName  ,@Param("emailId") String emailId ,
            Pageable pageable);
}