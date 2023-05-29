package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee emp);

	public List<Employee> getEmployees();

	public Employee getEmployeeById(int id);

	public Employee updateEmployee(Employee emp, int id);

	public Employee deleteEmployee(int id);

}
