package com.vaccine.vaccine.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "vaccine_reserve")
public class VaccineReserveIn {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "vaccine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vaccineId;

    @Column(name = "hospitalId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hospitalId;

    @Column(name = "vaccine_count")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vaccineCount;

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
