package com.fatmakara.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "photo")
@Getter
@Setter

public class Photo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private String title;

    @Column(name="image_url" ,nullable = false)
    private String imageUrl;


  @ManyToOne
 @JoinColumn(name="category_id")
   private Category category;


    @Column(length = 1000)
    private String description;

    private LocalDateTime createdAt;
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    private boolean isFeatured;

}


