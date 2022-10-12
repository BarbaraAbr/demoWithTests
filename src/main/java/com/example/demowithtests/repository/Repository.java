package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
//@Component
public interface Repository extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);

    List <Employee> findEmployeesByCountry(String country);

    Page<Employee> findByCountryContaining(String country, Pageable pageable);

    @NotNull
    Page <Employee> findAll (Pageable pageable);

    //SQL
    @Query(value = "Select * from users where name = ?1", nativeQuery = true)
    List<Employee> find (String name);

    //SQL
    @Query(value = "Select * from users where country = ?1", nativeQuery = true)
    List<Employee> findByCountry (String country);

    //JPQL
    @Query(value = "SELECT e FROM Employee e where e.email = ?1")
    Employee getOneByEmail (String email);
    //JPQL
    @Query(value = "SELECT e FROM Employee e where e.email = ?1")
    Employee updateEmail (String email, Employee employee);

    @Query (value = "Select * from users where email like %?1 and is_deleted = false", nativeQuery = true)
    Page <Employee> findEmployeeByEmailEndsWith (String partOfEmail, Pageable pageable);
}
