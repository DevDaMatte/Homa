package com.demoex.hamster.WEB.Controller;

import com.demoex.hamster.Domain.Models.Characteristic;
import com.demoex.hamster.Infrastructure.services.CharacteristicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/characteristics")
public class CharacteristicController {

    @Autowired
    private CharacteristicService characteristicService;

    @PostMapping("/{hamsterId}")
    public Characteristic addCharacteristicToHamster(@PathVariable int hamsterId, @RequestBody Characteristic characteristic) {
        return characteristicService.addCharacteristicToHamster(hamsterId, characteristic);
    }
    @PostMapping
    public Characteristic createCharacteristic(@RequestBody Characteristic characteristic) {
        return characteristicService.addCharacteristic(characteristic);
    }
    @DeleteMapping("{id}")
    public void removeCharacteristic(@PathVariable int id) {
        characteristicService.deleteCharacteristicById(id);
    }

    @PutMapping("/{hamsterId}/{characteristicId}")
    public Characteristic updateHamsterCharacteristic(@PathVariable int hamsterId, @PathVariable int characteristicId, @RequestBody Characteristic updatedCharacteristic) {
        return characteristicService.updateHamsterCharacteristic(hamsterId, characteristicId, updatedCharacteristic);
    }

    @DeleteMapping("/{hamsterId}/{characteristicId}")
    public void deleteCharacteristicFromHamster(@PathVariable int hamsterId, @PathVariable int characteristicId) {
        characteristicService.deleteCharacteristicFromHamster(hamsterId, characteristicId);
    }
}