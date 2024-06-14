package com.demoex.hamster.Domain.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Hamster {
    @Id
    private int ID;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date birthdate;

    private String color;

    @OneToMany(mappedBy = "hamster", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Characteristic> characteristics;
}
