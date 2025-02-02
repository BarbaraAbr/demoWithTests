package com.example.demowithtests.service;

import com.example.demowithtests.domain.Employee;

import java.util.List;

public interface Service {

    Employee create(Employee employee);

    List<Employee> getAll();

    Employee getById(Integer id);

    Employee updateById(Integer id, Employee plane);

    void removeById(Integer id);

    void removeAll();

    List <Employee> find (String name);

    List <Employee> findByCountry (String country);

    Employee getOneByEmail (String email);

    Employee updateEmail (String email, Employee employee);
}
