package com.example.demowithtests.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "driving_licence_id")
    private DrivingLicence drivingLicence;

//    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn (name = "employee_id")
//    private List <DrivingLicence> drivingLicences = new ArrayList<>();

    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "e_document_id")
    private EDocument eDocument;

    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "international_passport_id")
    private InternationalPassport internationalPassport;

    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "passport_id")
    private InternationalPassport Passport;

    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "student_card_id")
    private InternationalPassport studentCard;

}
