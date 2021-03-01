package spring.training.personal.petclinic.services.jpa;

import spring.training.personal.petclinic.model.Vet;
import spring.training.personal.petclinic.repositories.VetRepository;
import spring.training.personal.petclinic.services.VetService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Primary
@Profile({"default", "jpa"})
public class VetJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetJpaService(final VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);

        return vets;
    }

    @Override
    public Vet findById(final Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(final Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(final Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
