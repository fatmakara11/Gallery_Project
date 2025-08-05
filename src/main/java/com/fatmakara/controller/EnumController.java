package com.fatmakara.controller;

import com.fatmakara.enums.ContractType;
import com.fatmakara.enums.EmploymentStatus;
import com.fatmakara.enums.Gender;
import com.fatmakara.enums.Position;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enums")
@CrossOrigin(origins = "*")
public class EnumController {

    @GetMapping("/genders")
    public Gender[] getGenders() {
        return Gender.values();
    }
    @GetMapping("/positions")
    public Position[] getPositions() {
        return Position.values();
    }
    @GetMapping("/contract-types")
    public ContractType[] getContractTypes() {
        return ContractType.values();
    }
    @GetMapping("/employment-statuses")
    public EmploymentStatus[] getEmploymentStatuses() {
        return EmploymentStatus.values();
    }
}
