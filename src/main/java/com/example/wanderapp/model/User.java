package com.example.wanderapp.model;


import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(unique = true, nullable = false, length = 50)
    private String userName;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String password;

    @Column
    private java.sql.Date DOB;

    @Column
    private String profilePicUrl;

    @Column(length = 1000)
    private String bio;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isAdmin;










}
