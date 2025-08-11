package com.fatmakara.repository;

import com.fatmakara.dto.EmployeeFilterRequest;
import com.fatmakara.entities.Employee;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecification {
    // Burada filtreleme koşulları dinamik olarak oluşturuluyor.
    // Specification JPA’nın gelişmiş filtreleme mantığını kullanıyor
    public static Specification<Employee> filterBy(EmployeeFilterRequest request) {
        return (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->{
            List<Predicate> predicates = new ArrayList<>();

            //isim
            if(request.getFirstName() != null && !request.getFirstName().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("firstName")), "%" + request.getFirstName().toLowerCase() + "%"));
            }
            //soyisim
            if(request.getLastName() !=null && !request.getLastName().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("lastName")), "%" + request.getLastName().toLowerCase() + "%"));
            }
            //sehir(adress-->city
            if(request.getCity() != null && !request.getCity().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("city")), "%" + request.getCity().toLowerCase() + "%"));
            }
            //cinsiyet
            if(request.getGender() !=null){
                predicates.add(cb.equal(root.get("gender"), request.getGender()));
            }
            //pozisyon
            if(request.getPosition() !=null){
                predicates.add(cb.equal(root.get("position"), request.getPosition()));
            }
            //durum
            if(request.getEmploymentStatus() !=null){
                predicates.add(cb.equal(root.get("employmentStatus"), request.getEmploymentStatus()));
            }
            //sözleşme tipi
            if(request.getContractType() !=null){
                predicates.add(cb.equal(root.get("contractType"), request.getContractType()));
            }
            //SIRALAMA
            List<Order> orders = new ArrayList<>();
            //yaşa göre sıralama(su anki tarih - dogum tarihi)
            if("asc".equalsIgnoreCase(request.getAgeOrder())){
                orders.add(cb.asc(root.get("birthDate")));
            }else if("desc".equalsIgnoreCase(request.getAgeOrder())){
                orders.add(cb.desc(root.get("birthDate")));
            }
            //ise giris tarihine göre
            if("asc".equalsIgnoreCase(request.getHireDateOrder())){
                orders.add(cb.asc(root.get("hireDate")));
            }else if("desc".equalsIgnoreCase(request.getHireDateOrder())){
                orders.add(cb.desc(root.get("hireDate")));
            }
            if(!orders.isEmpty()){
                query.orderBy(orders);
            }
            return cb.and(predicates.toArray(new Predicate[0]));

        };
    }
}
