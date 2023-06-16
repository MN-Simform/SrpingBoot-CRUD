package com.springboot.controller;

import com.springboot.entity.Employee;
import com.springboot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> showEmployee(){
       return employeeService.employeeList();
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Emp Added";
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        employeeService.updateEmployee(id, employee);
        return "Updated";
    }

    @DeleteMapping("delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "Deleted";
    }

}
