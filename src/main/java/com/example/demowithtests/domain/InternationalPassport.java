package com.example.demowithtests.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "international_passport")
public class InternationalPassport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "number_card")
    private String numberCard;

    @Column (name = "gender")
    private String gender;

    @Column (name = "date_of_birth")
    private String dateOfBirth;

    @Column (name = "nationality")
    private String nationality;

    @Column (name = "authority")
    private Integer authority;

    @Column (name = "date_of_issue")
    private String dateOfIssue;

    @Column (name = "date_of_expiry")
    private String dateOfExpiry;

    @Column (name = "type")
    private String type;

    @Column (name = "country_code")
    private String countryCode;

    @Column (name = "place_of_birth")
    private String placeOfBirth;

    @Column (name = "legal_address")
    private String legalAddress;

    @Column (name = "is_active")
    private Boolean isActive;
}
