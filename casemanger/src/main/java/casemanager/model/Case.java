package casemanager.model;

import casemanager.types.Status;

import javax.persistence.*;

@Entity
@Table(name = "cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseId;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Integer severity;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
