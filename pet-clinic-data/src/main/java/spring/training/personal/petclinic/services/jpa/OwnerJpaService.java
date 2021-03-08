package spring.training.personal.petclinic.services.jpa;

import spring.training.personal.petclinic.model.Owner;
import spring.training.personal.petclinic.repositories.OwnerRepository;
import spring.training.personal.petclinic.repositories.PetRepository;
import spring.training.personal.petclinic.repositories.PetTypeRepository;
import spring.training.personal.petclinic.services.OwnerService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Primary
@Profile({"default", "jpa"})
public class OwnerJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(final OwnerRepository ownerRepository,
                           final PetRepository petRepository,
                           final PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();

        ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Owner findById(final Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(final Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(final Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return ownerRepository.findByLastName(lastName).orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameContaining(final String lastName) {
        return ownerRepository.findAllByLastNameContaining(lastName);
    }
}
