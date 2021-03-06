package spring.training.personal.petclinic.services.jpa;

import spring.training.personal.petclinic.model.Visit;
import spring.training.personal.petclinic.repositories.VisitRepository;
import spring.training.personal.petclinic.services.VisitService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Primary
@Profile({"default", "jpa"})
public class VisitJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJpaService(final VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(final Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(final Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(final Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
        visitRepository.deleteById(aLong);
    }

//    @Override
//    public Set<Visit> findByPetId(final Long petId) {
//        return null;
//    }
}
