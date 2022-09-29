package com.example.demowithtests.service;

import com.example.demowithtests.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service {

    Employee create(Employee employee);

    List<Employee> getAll();

    Page<Employee> getAllWithPagination(Pageable pageable);

    Employee getById(Integer id);

    Employee updateById(Integer id, Employee plane);

    void removeById(Integer id);

    void removeAll();

    //Page<Employee> findByCountryContaining(String country, Pageable pageable);
    /**
     * @param country  Filter for the country if required
     * @param page            number of the page returned
     * @param size            number of entries in each page
     * @param sortList        list of columns to sort on
     * @param sortOrder       sort order. Can be ASC or DESC
     * @return Page object with customers after filtering and sorting
     */
    Page<Employee> findByCountryContaining(String country, int page, int size, List<String> sortList, String sortOrder);

    List <Employee> find (String name);

    List <Employee> findByCountry (String country);

    Employee getOneByEmail (String email);

    Employee updateEmail (String email, Employee employee);
}
