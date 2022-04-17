package com.vaccine.vaccine.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vaccine")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Vaccine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    @Column(name = "day")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int day;
}
