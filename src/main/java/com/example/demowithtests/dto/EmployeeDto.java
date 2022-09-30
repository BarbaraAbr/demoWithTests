package com.example.demowithtests.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class EmployeeDto {
    @NotNull( message = "Name may not be null")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @Schema(description = "Name of an employee.", example = "Billy", required = true)
    private String name;

    @Schema(description = "Name of the country.", example = "USA", required = true)
    private String country;

    @Email
    @Schema(description = "Email address of an employee.", example = "b@gmail.com", required = true)
    private String email;

}
