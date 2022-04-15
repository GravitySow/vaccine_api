package com.vaccine.vaccine.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "User")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @Column(name = "password")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String password;

    @Column(name = "firstname")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String firstname;

    @Column(name = "surname")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String surname;

    @Column(name = "idcardno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idCardNO;

    @Column(name = "birthday")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date birthday;

    @Column(name = "gender")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String gender;

    @Column(name = "email")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;

    @Column(name = "address")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String address;

    @Column(name = "tel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tel;

    @Column(name = "create_date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date createDate;

    @Column(name = "update_date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date updateDate;
}
