package com.example.demowithtests.web;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeReadDto;
import com.example.demowithtests.dto.EmployeeSaveDto;
import com.example.demowithtests.dto.EmployeeUpdateDto;
import com.example.demowithtests.service.Service;
import com.example.demowithtests.util.config.EmployeeConverter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Employee", description = "Employee API")
public class Controller {

    private final Service service;
    private final EmployeeConverter converter;

    //Операция сохранения юзера в базу данных
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "This is endpoint to add a new employee.", description = "Create request to add a new employee.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED. The new employee is successfully created and added to database."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found."),
            @ApiResponse(responseCode = "409", description = "Employee already exists")})
    @PreAuthorize("hasAuthority('users:post')")
    public EmployeeSaveDto saveEmployee(@RequestBody @Valid EmployeeSaveDto requestForSave) {
        var employee = converter.getMapperFacade().map(requestForSave, Employee.class);
        var dto = converter.toDto(service.create(employee));

        return dto;
    }

    //Получение списка юзеров
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('users:get')")
    public List<Employee> getAllUsers() {
        return service.getAll();
    }

    @GetMapping("/users/p")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('users:get')")
    public Page<Employee> getPage(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size
    ) {
        Pageable paging = PageRequest.of(page, size);
        return service.getAllWithPagination(paging);
    }

    //Получения юзера по id
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint returned a employee by his id.", description = "Create request to read a employee by id", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found."),
            @ApiResponse(responseCode = "409", description = "Employee already exists")})
    @PreAuthorize("hasAuthority('users:get')")
    public EmployeeReadDto getEmployeeById(@PathVariable Integer id) {
        log.debug("getEmployeeById() Controller - start: id = {}", id);
        var employee = service.getById(id);
        log.debug("getById() Controller - to dto start: id = {}", id);
        var dto = converter.toReadDto(employee);
        log.debug("getEmployeeById() Controller - end: name = {}", dto.name);
        return dto;
    }

    //Обновление юзера
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to update the employee.", description = "Create request to update the employee.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found."),
            @ApiResponse(responseCode = "409", description = "Employee already exists")})
    @PreAuthorize("hasAuthority('users:put')")
    public EmployeeUpdateDto refreshEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        var e = service.updateById(id, employee);

        var dto = converter.employeeUpdateDto(e);
        return dto;
    }

    //Удаление по id
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('users:patch')")
    public void removeEmployeeById(@PathVariable Integer id) {
        service.removeById(id);
    }

    //Удаление всех юзеров
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('users:delete')")
    public void removeAllUsers() {
        service.removeAll();
    }

    //PARAMS
    @GetMapping(value = "/users", params = {"name"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('users:get')")
    public List<Employee> find(@RequestParam(value = "name") String name) {
        return service.find(name);
    }

    //PARAMS
    @GetMapping(value = "/users", params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('users:get')")
    public List<Employee> findByCountry(@RequestParam(value = "country") String country) {
        return service.findByCountry(country);
    }

    //PARAMS
    @GetMapping(value = "/users", params = {"email"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('users:get')")
    public Employee getOneByEmail(@RequestParam(value = "email") String email) {

        return service.getOneByEmail(email);
    }

    //BODY
    @PutMapping("/users/{email}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('users:put')")
    public Employee refreshEmail(@PathVariable("email") String email, @RequestBody Employee employee) {

        return service.updateEmail(email, employee);
    }

    @GetMapping("/users/country")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('users:get')")
    public Page<Employee> findByCountry(@RequestParam(required = false) String country,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "3") int size,
                                        @RequestParam(defaultValue = "") List<String> sortList,
                                        @RequestParam(defaultValue = "DESC") Sort.Direction sortOrder) {
        //Pageable paging = PageRequest.of(page, size);
        //Pageable paging = PageRequest.of(page, size, Sort.by("name").ascending());
        return service.findByCountryContaining(country, page, size, sortList, sortOrder.toString());
    }

    @GetMapping(value = "/users/email")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('users:get')")
    public Page<Employee> getEmployeeByEmail(@RequestParam String partOfEmail,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size,
                                             @RequestParam(defaultValue = "") List<String> sortList,
                                             @RequestParam(defaultValue = "DESC") Sort.Direction sortOrder)
    {
        log.info("start");
        return service.findEmployeeByEmailEndsWith(partOfEmail, page, size, sortList, sortOrder.toString());
    }

    @GetMapping(value = "/users/{country}/s")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('users:get')")
    public List<EmployeeReadDto> getEmployeesByCountry(@PathVariable String country) {
        var e = service.getEmployeesByCountry(country);
        var dto = converter.toDtoList(e);
        return dto;
        //return service.getEmployeesByCountry(country);
    }

        @GetMapping(value = "/users/country/st")
        @ResponseStatus(HttpStatus.OK)
        @PreAuthorize("hasAuthority('users:get')")
        public List<EmployeeReadDto> getEmployeesByCountryContainsJ () {
            var e = service.getEmployeesByCountryContaining();
            var dto = converter.toDtoList(e);
            return dto;
    }
}
