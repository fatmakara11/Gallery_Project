package com.fatmakara.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fatmakara.enums.ContractType;
import com.fatmakara.enums.EmploymentStatus;
import com.fatmakara.enums.Gender;
import com.fatmakara.enums.Position;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "city")
    private  String city;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties("employees") // döngüyü önlemek için
    private Department department;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnoreProperties("employees")
    private Team team;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "email", length=100)
    private  String email;

    @Column(name="phone", length=20)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @Enumerated(EnumType.STRING)
    @Column(name = "employment_status")
    private EmploymentStatus employmentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type")
    private ContractType contractType;



}
