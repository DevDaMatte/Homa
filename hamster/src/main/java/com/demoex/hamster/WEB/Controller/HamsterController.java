package com.demoex.hamster.WEB.Controller;

import com.demoex.hamster.Domain.Models.Hamster;
import com.demoex.hamster.Infrastructure.services.HamsterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController(value = "hamsters")
@RequiredArgsConstructor
public class HamsterController {

    @Autowired
    private HamsterService hamsterService;

    @GetMapping
    public List<Hamster> getAllHamsters() {
        return hamsterService.getHamsters();
    }

    @GetMapping("/{id}")
    public Optional<Hamster> getHamsterById(@PathVariable int id) {
        return hamsterService.getHamsterById(id);
    }

    @PostMapping
    public Hamster createHamster(@RequestBody Hamster hamster) {
        return hamsterService.createHamster(hamster);
    }

    @PutMapping("/{id}")
    public Hamster updateHamster(@PathVariable int id, @RequestBody Hamster updatedHamster) {
        return hamsterService.updateHamster(id, updatedHamster);
    }

    @DeleteMapping("/{id}")
    public void deleteHamster(@PathVariable int id) {
        hamsterService.deleteHamster(id);
    }
}
