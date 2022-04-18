package com.vaccine.vaccine.entities;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "vaccine_reserve")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class VaccineReserveHopital {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private Users users;

    @JsonIgnore
    @Column(name = "vaccine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vaccineId;

    @ManyToOne
    @JoinColumn(name = "vaccine_id", insertable=false, updatable=false)
    private Vaccine vaccine;

    @ManyToOne
    @JoinColumn(name = "hospitalId", insertable=false, updatable=false)
    private Hospital hospital;

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
