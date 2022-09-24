package com.example.demowithtests;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.repository.Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositoryTests {

    @Autowired
    private Repository repository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest() {

        Employee employee = Employee.builder().name("Mark").country("England").build();

        repository.save(employee);

        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getEmployeeTest() {

        Employee employee = repository.findById(1).orElseThrow();

        Assertions.assertThat(employee.getId()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void getListOfEmployeeTest() {

        List<Employee> employeesList = repository.findAll();

        Assertions.assertThat(employeesList.size()).isGreaterThan(0);

    }


    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest() {

        Employee employee = repository.findById(1).get();

        employee.setName("Martin");
        Employee employeeUpdated = repository.save(employee);

        Assertions.assertThat(employeeUpdated.getName()).isEqualTo("Martin");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest() {

        Employee employee = repository.findById(1).get();

        repository.delete(employee);

        //repository.deleteById(1L);

        Employee employee1 = null;

        Optional<Employee> optionalAuthor = Optional.ofNullable(repository.findByName("Martin"));

        if (optionalAuthor.isPresent()) {
            employee1 = optionalAuthor.get();
        }

        Assertions.assertThat(employee1).isNull();
    }

    @Test
    @Order(6)
    public void findTest() {

        Employee employee = new Employee();
        employee.setName("A");
        repository.save(employee);

        Assertions.assertThat(employee.getName()).isEqualTo("A");

    }

    @Test
    @Order(7)
    public void findByCountryTest() {

        Employee employee = new Employee();
        employee.setCountry("USA");
                repository.findByCountry("USA");

        Assertions.assertThat(employee.getCountry()).isEqualTo("USA");

    }

    @Test
    @Order(8)
    public void getOneByEmailTest() {

        Employee employee = new Employee();
        employee.setEmail("a");
        repository.getOneByEmail("a");

        Assertions.assertThat(employee.getEmail()).isEqualTo("a");

    }

    @Test
    @Order(9)
    @Rollback(value = false)
    public void updateEmailTest() {

        Employee employee = Employee.builder().name("Mark").country("England").email("a").build();

        repository.save(employee);

        repository.getOneByEmail("a");

        employee.setEmail("b");
        Employee employeeUpdated = repository.save(employee);

        Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("b");

    }


}
