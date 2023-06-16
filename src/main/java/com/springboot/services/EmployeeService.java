package com.springboot.services;

import com.springboot.entity.Employee;
import com.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> employeeList(){
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void updateEmployee(int id, Employee employee){
        Employee emp = employeeRepository.findById(id);
        emp.setName(employee.getName());
        emp.setDept(employee.getDept());
        emp.setSalary(employee.getSalary());
        employeeRepository.save(emp);
    }

    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }
}
