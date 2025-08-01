package com.fatmakara.services.impl;

import com.fatmakara.entities.Department;
import com.fatmakara.repository.DepartmentRepository;
import com.fatmakara.services.IDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        Optional<Department> optional = departmentRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteDepartment(Integer id) {
        Department dbDepartment = getDepartmentById(id);
        if (dbDepartment != null) {
            departmentRepository.delete(dbDepartment);
        }
    }

    @Override
    public Department updateDepartment(Integer id, Department updatedDepartment) {
        Department dbDepartment = getDepartmentById(id);
        if (dbDepartment != null) {
            dbDepartment.setName(updatedDepartment.getName());
            // Eğer ileride Department içindeki çalışanlarla ilgili update olacaksa eklenir
            return departmentRepository.save(dbDepartment);
        }
        throw new RuntimeException("Departman bulunamadı. ID: " + id);
    }
}
