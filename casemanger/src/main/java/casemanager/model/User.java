package casemanager.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Integer email;

}
