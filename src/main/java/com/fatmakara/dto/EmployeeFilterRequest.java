package com.fatmakara.dto;

import com.fatmakara.enums.ContractType;
import com.fatmakara.enums.EmploymentStatus;
import com.fatmakara.enums.Gender;
import com.fatmakara.enums.Position;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeFilterRequest {
    private String firstName;
    private String lastName;
    private String city;
    private Gender gender;
    private Position position;
    private EmploymentStatus employmentStatus;
    private ContractType contractType;
    private String ageOrder;   // asc veya desc
    private String hireDateOrder;  //asc veya desc
}
