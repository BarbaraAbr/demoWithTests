package com.example.demowithtests.util.mapstruct;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeDto;
import com.example.demowithtests.dto.EmployeeReadDto;
import com.example.demowithtests.dto.EmployeeUpdateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "interface")
public interface EmployeeMapper {

    EmployeeReadDto employeeReadDto(Employee employee);

    EmployeeDto createDto (Employee employee);

    EmployeeUpdateDto updateEmployeeDto(Employee employee);

    Employee createFromDto (EmployeeDto employeeDto);

    Employee updateEmployeeFromDto (EmployeeUpdateDto employeeUpdateDto);

}
