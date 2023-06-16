package com.springboot.repository;

import com.springboot.entity.Employee;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("Select e from Employee e where e.id = ?1")
    public Employee findById(int id);
    
}
