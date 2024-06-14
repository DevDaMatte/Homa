package com.demoex.hamster.Domain.Repository;

import com.demoex.hamster.Domain.Models.Hamster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HamsterRepository extends JpaRepository<Hamster, Integer> {
}
