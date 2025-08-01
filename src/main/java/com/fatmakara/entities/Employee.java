package com.fatmakara.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Column(name = "photo")
    private String photo; //görsel ekleme

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties("employees") // döngüyü önlemek için
    private Department department;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnoreProperties("employees")
    private Team team;

}
