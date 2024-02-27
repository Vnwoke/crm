package com.example.crown.crown.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100,nullable = false)
    private String email;

    @Column
    private Long phonenumber;

    @Column(length = 100, nullable = false)
    private String address;

    //@Column
   // private Boolean enroll;

    //@Column
    //private Boolean cancel;

    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY)
    private Set<Contact> contacts;
}
