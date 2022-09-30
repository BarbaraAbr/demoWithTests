package com.example.demowithtests.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor @NoArgsConstructor

public class EmployeeReadDto {
    private String name;
    private String country;
    private String email;
}
