package com.example.katacerveza.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "breweries", schema = "kata-api")
public class Brewery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String address1;
    @Column
    private String address2;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String code;
    @Column
    private String phone;
    @Column
    private String website;
    @Column
    private String filePath;
    @Column
    private String description;
    @Column
    private int addUser;
    @Column
    private Date lastMod;
}
