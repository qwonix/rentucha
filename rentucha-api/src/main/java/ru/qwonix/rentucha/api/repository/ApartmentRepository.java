package ru.qwonix.rentucha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.qwonix.rentucha.api.entity.Apartment;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findAllByCityNameContainsIgnoreCase(String name);
}
