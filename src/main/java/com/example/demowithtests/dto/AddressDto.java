package com.example.demowithtests.dto;


import java.time.Instant;
import java.util.Date;

public class AddressDto {

    public Long id;

    public String country;

    public String city;

    public String street;

    public String houseNumber;

    public Boolean addressHasActive = Boolean.TRUE;

    public Date date = Date.from(Instant.now());
}
