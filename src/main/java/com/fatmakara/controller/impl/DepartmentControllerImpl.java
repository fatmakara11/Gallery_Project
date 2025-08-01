package com.fatmakara.controller.impl;

import com.fatmakara.controller.IDepartmentController;
import com.fatmakara.entities.Department;
import com.fatmakara.services.IDepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "http://localhost:4200")  // Angular frontend için
public class DepartmentControllerImpl implements IDepartmentController {

    private final IDepartmentService departmentService;

    public DepartmentControllerImpl(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @Override
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @Override
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }

    @Override
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Integer id, @RequestBody Department updatedDepartment) {
        return departmentService.updateDepartment(id, updatedDepartment);
    }
}
