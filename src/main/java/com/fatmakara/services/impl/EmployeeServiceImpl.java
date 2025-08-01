package com.fatmakara.services.impl;

import com.fatmakara.entities.Department;
import com.fatmakara.entities.Employee;
import com.fatmakara.entities.Team;
import com.fatmakara.repository.DepartmentRepository;
import com.fatmakara.repository.EmployeeRepository;
import com.fatmakara.repository.TeamRepository;
import com.fatmakara.services.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final TeamRepository teamRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository,
                               TeamRepository teamRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        // ID ile Department bul ve set et
        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department department = departmentRepository.findById(employee.getDepartment().getId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            employee.setDepartment(department);
        }

        // ID ile Team bul ve set et
        if (employee.getTeam() != null && employee.getTeam().getId() != null) {
            Team team = teamRepository.findById(employee.getTeam().getId())
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            employee.setTeam(team);
        }

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setHireDate(updatedEmployee.getHireDate());

            // İlişkileri güncelle
            if (updatedEmployee.getDepartment() != null && updatedEmployee.getDepartment().getId() != null) {
                Department department = departmentRepository.findById(updatedEmployee.getDepartment().getId())
                        .orElseThrow(() -> new RuntimeException("Department not found"));
                employee.setDepartment(department);
            }

            if (updatedEmployee.getTeam() != null && updatedEmployee.getTeam().getId() != null) {
                Team team = teamRepository.findById(updatedEmployee.getTeam().getId())
                        .orElseThrow(() -> new RuntimeException("Team not found"));
                employee.setTeam(team);
            }

            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
