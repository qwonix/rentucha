package ru.qwonix.rentucha.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.qwonix.rentucha.api.entity.Apartment;
import ru.qwonix.rentucha.api.repository.ApartmentRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApartmentController {
    private final ApartmentRepository repository;

    ApartmentController(ApartmentRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/apartments")
    List<Apartment> getAllApartments() {
        return repository.findAll();
    }

    @GetMapping(value = "/apartments", params = "query")
    List<Apartment> getApartmentsByQuery(@RequestParam(name = "query", required = false) String query) {
        return new ArrayList<>(repository.findAllByCityNameContainsIgnoreCase(query));
    }

    @GetMapping("/apartments/{id}")
    Apartment getApartmentById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find apartment " + id));
    }
}
