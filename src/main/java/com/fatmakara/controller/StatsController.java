package com.fatmakara.controller;

import com.fatmakara.entities.Department;
import com.fatmakara.repository.DepartmentRepository;
import com.fatmakara.repository.EmployeeRepository;
import com.fatmakara.repository.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = "http://localhost:4200") // Angular için CORS
public class StatsController {

    private final DepartmentRepository departmentRepository;
    private final TeamRepository teamRepository;
    private final EmployeeRepository employeeRepository;

    public StatsController(DepartmentRepository departmentRepository,
                           TeamRepository teamRepository,
                           EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.teamRepository = teamRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/departments/count")
    public Long getDepartmentCount() {
        return departmentRepository.count();
    }

    @GetMapping("/teams/count")
    public Long getTeamCount() {
        return teamRepository.count();
    }

    @GetMapping("/employees/count")
    public Long getEmployeeCount() {
        return employeeRepository.count();
    }
    @GetMapping("/employee-count-by-department")
    public Map<String, Long> getEmployeesCountByDepartment() {
        return departmentRepository.findAll().stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        d -> (long) employeeRepository.countByDepartment(d)
                ));
    }
}
