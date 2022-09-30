package com.example.demowithtests.web;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeDto;
import com.example.demowithtests.dto.EmployeeReadDto;
import com.example.demowithtests.dto.EmployeeUpdateDto;
import com.example.demowithtests.service.Service;
import com.example.demowithtests.util.mapstruct.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ControllerDtoCl implements ControllerDto {

    private final Service service;
    private final EmployeeMapper mapper;

    @Override
    @GetMapping("/users/{id}/dto")
    public EmployeeReadDto getEmployeeByIdDto(@PathVariable Integer id) {
        return mapper.employeeReadDto(service.getById(id));
    }

    @Override
    @PostMapping("/users/create_dto")
    public EmployeeDto saveEmployeeDto(@RequestBody @Valid EmployeeDto employeeDto) {
        Employee employee = mapper.createFromDto(employeeDto);
        return mapper.createDto(service.create(employee));
    }

    @Override
    @PutMapping("/users/{id}/update_dto")
    public EmployeeUpdateDto refreshEmployeeDto(@PathVariable("id") Integer id,
                                                @RequestBody @Valid EmployeeUpdateDto employeeUpdateDto) {
        Employee employee = mapper.updateEmployeeFromDto(employeeUpdateDto);
        return mapper.updateEmployeeDto(service.updateById(id, employee));
    }
}
