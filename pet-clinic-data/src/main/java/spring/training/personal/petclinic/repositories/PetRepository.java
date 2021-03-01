package spring.training.personal.petclinic.repositories;

import spring.training.personal.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
