package com.example.demowithtests.dto;

import java.time.Instant;
import java.util.Date;

public class PassportDto {
    public Integer id;
    public Long number;
    public String gender;
    public String dateOfBirth;
    public String nationality;
    public Integer authority;
    public String dateOfIssue;
    public String dateOfExpiry;
    public Long taxNumber;
    public String placeOfBirth;
    public String placeOfResidence;
    public Boolean isActive;
    public Date date = java.util.Date.from(Instant.now());
}
