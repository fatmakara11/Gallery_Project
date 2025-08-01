package com.fatmakara.controller.impl;

import com.fatmakara.controller.IEmployeeController;
import com.fatmakara.entities.Employee;
import com.fatmakara.services.IEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeControllerImpl implements IEmployeeController {

    private final IEmployeeService employeeService;

    public EmployeeControllerImpl(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @Override
    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Override
    @GetMapping("/list/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(
            @RequestPart("employee") Employee employee,
            @RequestPart("file") MultipartFile file) throws IOException {

        // Dosya yolunu oluştur
        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get("uploads/employee-images", fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());

        // Foto ismini ata
        employee.setPhoto(fileName);

        // Kaydet
        Employee saved = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(saved);
    }
}
