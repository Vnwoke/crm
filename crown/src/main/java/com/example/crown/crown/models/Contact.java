package com.example.crown.crown.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String guest;

    @Column
    private Boolean contacted;

    @Column
    private Date contactdate;

    @Column(length = 100, nullable = true)
    private String contactreason;

    @Column(length = 150, nullable = true)
    private String contactdescription;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    //staff who made the contact
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User staff;


}
