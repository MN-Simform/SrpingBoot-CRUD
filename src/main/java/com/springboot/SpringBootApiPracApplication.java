package com.springboot;

import com.springboot.entity.Employee;
import com.springboot.entity.EmployeeDetails;
import com.springboot.repository.EmployeeDetailsRepo;
import com.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootApiPracApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeDetailsRepo employeeDetailsRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiPracApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Employee> employee = new ArrayList<>();
		employee.addAll(employeeRepository.findAll());

		System.out.println(employee);

		List<EmployeeDetails> list = employee.stream().map(employee1 -> new EmployeeDetails(employee1.getId(), employee1.getName(), employee1.getSalary())).toList();
		System.out.println(list);
		list.forEach(employeeDetails -> employeeDetailsRepo.save(employeeDetails));
	}
}
