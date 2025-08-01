package com.fatmakara.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    // Bir takımda birden çok çalışan olabilir
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();
}
