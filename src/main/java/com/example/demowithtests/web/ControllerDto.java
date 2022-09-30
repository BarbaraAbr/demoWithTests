package com.example.demowithtests.web;

import com.example.demowithtests.dto.EmployeeDto;
import com.example.demowithtests.dto.EmployeeReadDto;
import com.example.demowithtests.dto.EmployeeUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface ControllerDto {

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "This is endpoint to add a new employee.", description = "Create request to add a new employee.", tags = {"Employee"})
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "CREATED. The new dto employee is successfully created and added to database."),
//            @ApiResponse(responseCode = "400", description = "Invalid input"),
//            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found."),
//            @ApiResponse(responseCode = "409", description = "Dto employee already exists")})
    EmployeeDto saveEmployeeDto(EmployeeDto employeeCreateDto);

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint returned a employee by his id.", description = "Create request to read a employee by id", tags = {"Employee"})
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "OK. pam pam param."),
//            @ApiResponse(responseCode = "400", description = "Invalid input"),
//            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found."),
//            @ApiResponse(responseCode = "409", description = "Employee already exists")})
    EmployeeReadDto getEmployeeByIdDto(Integer id);

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint allows to update all fields of employee.", description = "Create request to update employee.", tags = {"Employee"})
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "OK. Employee was updated"),
//            @ApiResponse(responseCode = "400", description = "Invalid input"),
//            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found.")})
    EmployeeUpdateDto refreshEmployeeDto(@PathVariable("id") Integer id,
                                         @RequestBody EmployeeUpdateDto employeeUpdateDto);
}
