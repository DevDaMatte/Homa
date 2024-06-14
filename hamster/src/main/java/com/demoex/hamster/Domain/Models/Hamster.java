package com.demoex.hamster.Domain.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Hamster {
    @Id
    private int ID;

    private String name;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime birthdate;

    private String color;

    @OneToMany(mappedBy = "hamster", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Characteristic> characteristics;
}
