package com.demoex.hamster.Domain.Repository;

import com.demoex.hamster.Domain.Models.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Integer> {
}
