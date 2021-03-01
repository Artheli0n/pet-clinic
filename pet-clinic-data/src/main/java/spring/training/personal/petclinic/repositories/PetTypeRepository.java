package spring.training.personal.petclinic.repositories;

import spring.training.personal.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
