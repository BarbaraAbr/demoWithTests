package com.example.demowithtests.dto;

import java.time.Instant;
import java.util.Date;

public class DrivingLicenceDto {
    public Integer id;
    public Long number;
    public String dateOfBirth;
    public String placeOfBirth;
    public String dateOfIssue;
    public String expiryDate;
    public Integer issuingAuthority;
    public String recordNumber;
    public String category;
    public String categoryIssuingDate;
    public Boolean isActive;
    public Date date = java.util.Date.from(Instant.now());
}
