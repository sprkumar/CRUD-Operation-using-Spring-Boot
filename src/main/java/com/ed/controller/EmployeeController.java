package com.ed.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ed.exception.ResourceNotFoundException;
import com.ed.model.Employee;
import com.ed.service.EmployeeService;

@RequestMapping("/api")
@RestController
public class EmployeeController {
	public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class.getName());

	@Autowired
	EmployeeService employeeService;

	// find all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.findAll();
	}

	// Find employee by id
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") Long id) {
		return employeeService.findById(id);
	}

	// add single employee
	@PostMapping("employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	// add multiple employee
	@PostMapping("employees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
		return employeeService.saveAll(employees);
	}

	// update employee
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		Employee emp = employeeService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Data not found  for id:", id));
		emp.setName(employee.getName());
		emp.setAddress(employee.getAddress());
		emp.setEmail(employee.getEmail());
		emp.setMobile(employee.getMobile());
		Employee updatedemp = employeeService.save(emp);
		return updatedemp;
	}

	// Delete employee by id
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteById(id);	
		return new ResponseEntity<>("Employee deleted successfully for Id: "+id, HttpStatus.OK);
	}
	
	// Delete all employee
	@DeleteMapping("/employees")
	public ResponseEntity<?> deleteAllEmployee() {
		employeeService.deleteAll();
		return new ResponseEntity<>("All Employee deleted successfully", HttpStatus.OK);
	}

}
