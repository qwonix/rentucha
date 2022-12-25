package ru.qwonix.rentucha.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.qwonix.rentucha.api.entity.Apartment;

@RepositoryRestResource(path = "apartments")
public interface ApartmentRepository extends CrudRepository<Apartment, Long> {
}
