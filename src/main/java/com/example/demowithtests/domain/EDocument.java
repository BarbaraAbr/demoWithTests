package com.example.demowithtests.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "e_document")
public class EDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "gender")
    private String gender;

    @Column (name = "date_of_birth")
    private String dateOfBirth;

    @Column (name = "nationality")
    private String Nationality;

    @Column (name = "number")
    private Long number;
}
