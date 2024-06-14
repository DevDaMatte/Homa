package com.demoex.hamster.Infrastructure.services;

import com.demoex.hamster.Domain.Models.Hamster;
import com.demoex.hamster.Domain.Repository.HamsterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class HamsterService {
    @Autowired
    private HamsterRepository hamsterRepository;

    public List<Hamster> getHamsters() {
        return hamsterRepository.findAll();
    }
    public Optional<Hamster> getHamsterById(int id) {
        return hamsterRepository.findById(id);
    }

    public Hamster createHamster(Hamster hamster) {
        return hamsterRepository.save(hamster);
    }

    public Hamster updateHamster(int id, Hamster updatedHamster) {
        return hamsterRepository.findById(id).map(hamster -> {
            hamster.setName(updatedHamster.getName());
            hamster.setBirthdate(updatedHamster.getBirthdate());
            hamster.setColor(updatedHamster.getColor());
            hamster.setCharacteristics(updatedHamster.getCharacteristics());
            return hamsterRepository.save(hamster);
        }).orElseGet(() -> {
            updatedHamster.setID(id);
            return hamsterRepository.save(updatedHamster);
        });
    }

    public void deleteHamster(int id) {
        hamsterRepository.deleteById(id);
    }

}
