package com.springboot.repository;

import com.springboot.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Integer> {
}
