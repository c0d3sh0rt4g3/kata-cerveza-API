package com.example.katacerveza.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "beers", schema = "kata-api")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int breweryId;
    @Column
    private String name;
    @Column
    private int catId;
    @Column
    private int styleId;
    @Column
    private float abv;
    @Column
    private float ibu;
    @Column
    private float srm;
    @Column
    private int upc;
    @Column
    private String filePath;
    @Column
    private String description;
    @Column
    private int addUser;
    @Column
    private Date lastMod;
}