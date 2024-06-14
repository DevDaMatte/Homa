package com.demoex.hamster.Infrastructure.services;

import com.demoex.hamster.Domain.Models.Characteristic;
import com.demoex.hamster.Domain.Models.Hamster;
import com.demoex.hamster.Domain.Repository.CharacteristicRepository;
import com.demoex.hamster.Domain.Repository.HamsterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class CharacteristicService {
    @Autowired
    private CharacteristicRepository characteristicRepository;

    @Autowired
    private HamsterRepository hamsterRepository;

    public Characteristic addCharacteristic(Characteristic characteristic) {
        return characteristicRepository.save(characteristic);
    }

    public Characteristic addCharacteristicToHamster(int hamsterId, Characteristic characteristic) {
        Optional<Hamster> optionalHamster = hamsterRepository.findById(hamsterId);
        if (optionalHamster.isPresent()) {
            Hamster hamster = optionalHamster.get();
            characteristic.setHamster(hamster);
            return characteristicRepository.save(characteristic);
        } else {
            throw new IllegalArgumentException("Hamster not found");
        }
    }

    public Characteristic updateHamsterCharacteristic(int hamsterId, int characteristicId, Characteristic updatedCharacteristic) {
        Optional<Hamster> optionalHamster = hamsterRepository.findById(hamsterId);
        if (optionalHamster.isPresent()) {
            Hamster hamster = optionalHamster.get();
            Optional<Characteristic> optionalCharacteristic = characteristicRepository.findById(characteristicId);
            if (optionalCharacteristic.isPresent() && optionalCharacteristic.get().getHamster().equals(hamster)) {
                Characteristic characteristic = optionalCharacteristic.get();
                characteristic.setName(updatedCharacteristic.getName());
                return characteristicRepository.save(characteristic);
            } else {
                throw new IllegalArgumentException("Characteristic not found for hamster");
            }
        } else {
            throw new IllegalArgumentException("Hamster not found");
        }
    }

    public void deleteCharacteristicById(int characteristicId) {
        characteristicRepository.deleteById(characteristicId);
    }

    public void deleteCharacteristicFromHamster(int hamsterId, int characteristicId) {
        Optional<Hamster> optionalHamster = hamsterRepository.findById(hamsterId);
        if (optionalHamster.isPresent()) {
            Hamster hamster = optionalHamster.get();
            Optional<Characteristic> optionalCharacteristic = characteristicRepository.findById(characteristicId);
            if (optionalCharacteristic.isPresent() && optionalCharacteristic.get().getHamster().equals(hamster)) {
                Characteristic characteristic = optionalCharacteristic.get();
                characteristic.setHamster(null);
                characteristicRepository.save(characteristic);
            } else {
                throw new IllegalArgumentException("Characteristic not found for hamster");
            }
        } else {
            throw new IllegalArgumentException("Hamster not found");
        }
    }
}
