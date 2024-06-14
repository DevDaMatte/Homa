package com.demoex.hamster.Domain.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Characteristic {

    @Id
    private int ID;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "hamster_id", nullable = false)
    private Hamster hamster;
}
