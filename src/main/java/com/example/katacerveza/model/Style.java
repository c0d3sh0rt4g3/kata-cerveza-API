package com.example.katacerveza.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "styles", schema = "kata-api")
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int catId;
    @Column
    private String styleName;
    @Column
    private Date lastMod;
}
