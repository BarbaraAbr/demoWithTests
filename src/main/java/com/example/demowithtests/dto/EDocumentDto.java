package com.example.demowithtests.dto;

import java.time.Instant;
import java.util.Date;

public class EDocumentDto {
    public Integer id;
    public String gender;
    public String dateOfBirth;
    public String Nationality;
    public Long number;
    public Date date = java.util.Date.from(Instant.now());
}
