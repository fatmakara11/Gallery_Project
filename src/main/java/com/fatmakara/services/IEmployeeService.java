package com.fatmakara.services;


import com.fatmakara.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
    void deleteEmployee(Integer id);
    Employee updateEmployee(Integer id, Employee updatedEmployee);
}