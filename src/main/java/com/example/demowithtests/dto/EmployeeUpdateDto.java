package com.example.demowithtests.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeUpdateDto {
    @NotNull(message = "Name must be not null")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @Schema(description = "Name of an employee.", example = "Billy", required = true)
    private String name;

    @Schema(description = "Name of the country", example = "England", required = true)
    private String country;

    @Email
    @NotNull
    @Schema(description = "Email of an employee", example = "qwerty@gmail.com", required = true)
    private String email;

}
