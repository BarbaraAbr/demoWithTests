package com.example.demowithtests.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_card")
public class StudentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "number_card")
    private Long numberCard;

    @Column (name = "university")
    private String university;

    @Column (name = "faculty")
    private String faculty;

    @Column (name = "date_of_issue")
    private String dateOfIssue;

    @Column (name = "date_of_expiry")
    private String dateOfExpiry;

    @Column (name = "form_of_education")
    private String formOfEducation;

    @Column (name = "is_active")
    private Boolean isActive;
}
