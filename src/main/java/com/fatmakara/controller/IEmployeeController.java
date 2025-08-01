package com.fatmakara.controller;

import com.fatmakara.entities.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IEmployeeController {
  ResponseEntity<Employee> createEmployee(@RequestPart("employee") Employee employee,
                                          @RequestPart("file") MultipartFile file) throws IOException;
  Employee saveEmployee(Employee employee);
  List<Employee> getAllEmployees();
  Employee getEmployeeById(Integer id);
  void deleteEmployee(Integer id);
  Employee updateEmployee(Integer id, Employee updatedEmployee);
}