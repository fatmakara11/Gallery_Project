package com.fatmakara.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@ComponentScan(basePackages = {"com.fatmakara"})
@EntityScan(basePackages = {"com.fatmakara.entities"})
@EnableJpaRepositories(basePackages = {"com.fatmakara"})
public class
GalleryProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(GalleryProjectApplication.class, args);
    }
}
