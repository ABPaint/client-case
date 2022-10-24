package com.example.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "projects")
    private String projects;

    @Column(name = "agreements")
    private String agreements;
}
