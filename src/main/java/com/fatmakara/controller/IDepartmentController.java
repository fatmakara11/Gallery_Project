package com.fatmakara.controller;

import com.fatmakara.entities.Department;

import java.util.List;

public interface IDepartmentController {
  Department saveDepartment(Department department);
  List<Department> getAllDepartments();
  Department getDepartmentById(Integer id);
  void deleteDepartment(Integer id);
  Department updateDepartment(Integer id, Department updatedDepartment);
}
