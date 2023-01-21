package ru.qwonix.rentucha.api.controller;

import org.springframework.web.bind.annotation.*;
import ru.qwonix.rentucha.api.entity.Apartment;
import ru.qwonix.rentucha.api.repository.ApartmentRepository;

import java.util.List;

@RestController
public class ApartmentController {
    private final ApartmentRepository repository;

    ApartmentController(ApartmentRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/apartments")
    List<Apartment> all() {
        return repository.findAll();
    }

    @PostMapping("/apartments")
    Apartment newEmployee(@RequestBody Apartment apartment) {
        return repository.save(apartment);
    }


    @GetMapping("/apartments/{id}")
    Apartment one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find apartment " + id));
    }


    @DeleteMapping("/apartments/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
