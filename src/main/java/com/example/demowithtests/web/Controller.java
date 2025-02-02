package com.example.demowithtests.web;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    private final Service service;

    //Операция сохранения юзера в базу данных
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.create(employee);
    }

    //Получение списка юзеров
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllUsers() {
        return service.getAll();
    }

    //Получения юзера по id
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable Integer id) {

        Employee employee = service.getById(id);
        return employee;
    }

    //Обновление юзера
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee refreshEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {

        return service.updateById(id, employee);
    }

    //Удаление по id
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable Integer id) {
        service.removeById(id);
    }

    //Удаление всех юзеров
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        service.removeAll();
    }

    //PARAMS
    @GetMapping(value = "/users", params = {"name"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> find(@RequestParam(value = "name") String name) {
        return service.find(name);
    }

    //PARAMS
    @GetMapping(value = "/users", params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findByCountry(@RequestParam(value = "country") String country) {
        return service.findByCountry(country);
    }

    //PARAMS
    @GetMapping(value = "/users", params = {"email"})
    @ResponseStatus(HttpStatus.OK)
    public Employee getOneByEmail(@RequestParam(value = "email") String email) {

        return service.getOneByEmail(email);
    }

    //BODY
    @PutMapping("/users/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Employee refreshEmail(@PathVariable("email") String email, @RequestBody Employee employee) {

        return service.updateEmail(email, employee);
    }
}
