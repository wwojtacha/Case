package casemanager.model;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;
    @ManyToOne
    @JoinColumn(name = "case_id")
    private Case myCase;
    @Column
    private String details;
}
