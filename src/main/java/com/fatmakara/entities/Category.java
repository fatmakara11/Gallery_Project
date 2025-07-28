package com.fatmakara.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "category_id",nullable = false)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;


    // Bir kategori birden çok fotoğrafa sahip olabilir
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Photo> photos = new ArrayList<>();

}
