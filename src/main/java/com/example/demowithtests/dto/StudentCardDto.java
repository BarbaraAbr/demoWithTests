package com.example.demowithtests.dto;

import java.time.Instant;
import java.util.Date;

public class StudentCardDto {
    public Integer id;
    public Long number;
    public String university;
    public String faculty;
    public String dateOfIssue;
    public String dateOfExpiry;
    public String formOfEducation;
    public Boolean isActive;
    public Date date = java.util.Date.from(Instant.now());
}
