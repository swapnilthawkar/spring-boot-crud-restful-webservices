package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {

		Employee employee = empService.addEmployee(emp);

		ResponseEntity<Employee> e1 = new ResponseEntity<Employee>(employee, HttpStatus.CREATED);

		return e1;

	}

	@GetMapping("/Employees")
	public List<Employee> getEmployees() {
		return empService.getEmployees();

	}

	@GetMapping("/Employees/employee/{id}")
	public ResponseEntity<?> getEmpById(@PathVariable("id") int empId) {
		Employee employee = empService.getEmployeeById(empId);

		ResponseEntity<Employee> e2 = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		return e2;

	}

	@PutMapping("/Update/employee/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp, @PathVariable("id") int empId) {
		Employee employee = empService.updateEmployee(emp, empId);
		ResponseEntity<Employee> e3 = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		return e3;

	}

	@DeleteMapping("/Delete/employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int empId) {
		Employee employee = empService.deleteEmployee(empId);
		ResponseEntity<Employee> e4 = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		return e4;

	}

}
