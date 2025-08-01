package com.fatmakara.repository;

import com.fatmakara.entities.Department;
import com.fatmakara.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    int countByDepartment(Department department);

}


//Jpa içinde olan bir çok fonksiyonu implement ederiz yani baştan fonksiyonlar yazmak yerine hazır fonksiyonları kullanırız
//artık repository katmanımız hazır.bunu sadece autowired ile enjekte edicez
//önce paketlerimizi oluşturduk sonra içlerine intereface classlarımızı oluşturduk .paketimizin iiçine ipl paketi açık oluşturduğımuz interiface classlarımızı implement ettik .bunu controller ve servicede yaptık sadece .Repositoryde yapmadım orada  JpaRepository yi extend ettik