package com.example.demowithtests.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "number")
    private Long number;

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

    @Column (name = "tax_number")
    private Long taxNumber;

    @Column (name = "place_of_birth")
    private String placeOfBirth;

    @Column (name = "place_of_residence")
    private String placeOfResidence;
}
