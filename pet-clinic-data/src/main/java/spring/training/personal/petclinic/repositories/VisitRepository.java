package spring.training.personal.petclinic.repositories;

import spring.training.personal.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
