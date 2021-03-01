package spring.training.personal.petclinic.repositories;

import spring.training.personal.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
