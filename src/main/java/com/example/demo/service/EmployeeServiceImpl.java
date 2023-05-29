package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.MyCustomeException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee addEmployee(Employee emp) {

		return repo.save(emp);
	}

	@Override
	public List<Employee> getEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> emp = repo.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		else {
			throw new ResourceNotFoundException("Employee","id",id);
		}
	}

	@Override
	public Employee updateEmployee(Employee emp, int id) {
		Employee existEmp = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id", id));
		
		existEmp.setName(emp.getName());
		existEmp.setSalary(emp.getSalary());
		existEmp.setCity(emp.getCity());
		repo.save(existEmp);
		return existEmp;
	}

	@Override
	public Employee deleteEmployee(int id) {
		Employee employee = repo.findById(id).orElseThrow(()-> new MyCustomeException("Employee not found please correct id: "+id));
		
		repo.delete(employee);
		
		return employee;
	}

}
