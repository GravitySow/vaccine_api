package com.vaccine.vaccine.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "vaccine_reserve")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class VaccineReserve {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "vaccine_id", insertable=false, updatable=false)
    private Vaccine vaccine;

    @ManyToOne
    @JoinColumn(name = "hospitalId", insertable=false, updatable=false)
    private Hospital hospital;

    @Column(name = "vaccine_count")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vaccine_count;

    @Column(name = "date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date date;

    @Column(name = "status")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String status;

    @Column(name = "create_date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date createDate;

    @Column(name = "update_date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date updateDate;
}
