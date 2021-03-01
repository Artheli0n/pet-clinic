package spring.training.personal.petclinic.services.jpa;

import spring.training.personal.petclinic.model.PetType;
import spring.training.personal.petclinic.repositories.PetTypeRepository;
import spring.training.personal.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Primary
@Profile({"default", "jpa"})
public class PetTypeJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJpaService(final PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> types = new HashSet<>();
        petTypeRepository.findAll().forEach(types::add);
        return types;
    }

    @Override
    public PetType findById(final Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(final PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(final PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
