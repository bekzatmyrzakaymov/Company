package com.example.task.repo;

import com.example.task.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query("SELECT u FROM Employee u WHERE u.email = ?1")
    Employee findByEmail(String email);
}
