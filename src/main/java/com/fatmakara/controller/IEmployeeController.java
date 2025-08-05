package com.fatmakara.controller;

import com.fatmakara.dto.EmployeeFilterRequest;
import com.fatmakara.entities.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeController {
  Employee saveEmployee(Employee employee);
  List<Employee> getAllEmployees();
  Employee getEmployeeById(Integer id);
  void deleteEmployee(Integer id);
  Employee updateEmployee(Integer id, Employee updatedEmployee);
  ResponseEntity<List<Employee>> filterEmployees(EmployeeFilterRequest request);
}