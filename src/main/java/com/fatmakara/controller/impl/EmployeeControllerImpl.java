package com.fatmakara.controller.impl;

import com.fatmakara.controller.IEmployeeController;
import com.fatmakara.dto.EmployeeFilterRequest;
import com.fatmakara.entities.Employee;
import com.fatmakara.services.IEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeControllerImpl implements IEmployeeController {

    private final IEmployeeService employeeService;

    public EmployeeControllerImpl(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @Override
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Override
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }

    @Override
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }
     @Override
     @PostMapping("/filter")
     public ResponseEntity<List<Employee>> filterEmployees(@RequestBody EmployeeFilterRequest request) {
         List<Employee> filtered = employeeService.filterEmployees(request);
         return ResponseEntity.ok(filtered);
     }

}
