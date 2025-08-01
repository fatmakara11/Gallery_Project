package com.fatmakara.repository;

import com.fatmakara.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    //Buralara kendi özel methotlarımızı yazacağız
}
