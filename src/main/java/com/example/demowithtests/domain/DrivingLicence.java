package com.example.demowithtests.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "driving_licence")
public class DrivingLicence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "number_card")
    private Long numberCard;

    @Column (name = "date_of_birth")
    private String dateOfBirth;

    @Column (name = "place_of_birth")
    private String placeOfBirth;

    @Column (name = "date_of_issue")
    private String dateOfIssue;

    @Column (name = "expiry_date")
    private String expiryDate;

    @Column (name = "issuing_authority")
    private Integer issuingAuthority;

    @Column (name = "record_number")
    private String recordNumber;

    @Column (name = "category")
    private String category;

    @Column (name = "category_issuing_date")
    private String categoryIssuingDate;

    @Column (name = "is_active")
    private Boolean isActive;
}
