package spring.training.personal.petclinic.services.jpa;

import spring.training.personal.petclinic.model.Speciality;
import spring.training.personal.petclinic.repositories.SpecialityRepository;
import spring.training.personal.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Primary
@Profile({"default", "jpa"})
public class SpecialityJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityJpaService(
            final SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(final Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(final Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(final Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
