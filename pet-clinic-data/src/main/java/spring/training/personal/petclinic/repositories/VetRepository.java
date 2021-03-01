package spring.training.personal.petclinic.repositories;

import spring.training.personal.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
