package com.fatmakara.services.impl;
import com.fatmakara.dto.EmployeeFilterRequest;
import com.fatmakara.entities.Department;
import com.fatmakara.entities.Employee;
import com.fatmakara.entities.Team;
import com.fatmakara.repository.DepartmentRepository;
import com.fatmakara.repository.EmployeeRepository;
import com.fatmakara.repository.EmployeeSpecification;
import com.fatmakara.repository.TeamRepository;
import com.fatmakara.services.IEmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;

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
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setFirstName(updatedEmployee.getFirstName());
        emp.setLastName(updatedEmployee.getLastName());
        emp.setCity(updatedEmployee.getCity());
        emp.setHireDate(updatedEmployee.getHireDate());
        emp.setBirthDate(updatedEmployee.getBirthDate());
        emp.setEmail(updatedEmployee.getEmail());
        emp.setPhone(updatedEmployee.getPhone());
        emp.setGender(updatedEmployee.getGender());
        emp.setPosition(updatedEmployee.getPosition());
        emp.setEmploymentStatus(updatedEmployee.getEmploymentStatus());
        emp.setContractType(updatedEmployee.getContractType());
        emp.setDepartment(updatedEmployee.getDepartment());
        emp.setTeam(updatedEmployee.getTeam());

        return employeeRepository.save(emp);
    }
//DTO’dan filtreyi alıp sorgu yapar
    @Override
    public List<Employee> filterEmployees(EmployeeFilterRequest request) {
        return employeeRepository.findAll(EmployeeSpecification.filterBy(request));
    }
    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
