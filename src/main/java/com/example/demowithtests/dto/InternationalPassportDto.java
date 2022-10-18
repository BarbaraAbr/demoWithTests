package com.example.demowithtests.dto;

import java.time.Instant;
import java.util.Date;

public class InternationalPassportDto {
    public Integer id;
    public String number;
    public String gender;
    public String dateOfBirth;
    public String nationality;
    public Integer authority;
    public String dateOfIssue;
    public String dateOfExpiry;
    public String type;
    public String countryCode;
    public String placeOfBirth;
    public String legalAddress;
    public Boolean isActive;
    public Date date = java.util.Date.from(Instant.now());
}
