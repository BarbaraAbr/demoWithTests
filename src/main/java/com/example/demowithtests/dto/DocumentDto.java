package com.example.demowithtests.dto;

import java.time.Instant;
import java.util.Date;

public class DocumentDto {
    public Long id;
    public Long number;
    public DrivingLicenceDto drivingLicenceDto;
    public EDocumentDto eDocumentDto;
    public InternationalPassportDto internationalPassportDto;
    public PassportDto passportDto;
    public StudentCardDto studentCardDto;
    public Date date = java.util.Date.from(Instant.now());
}
