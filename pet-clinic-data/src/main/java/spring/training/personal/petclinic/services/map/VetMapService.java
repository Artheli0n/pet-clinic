package spring.training.personal.petclinic.services.map;

import spring.training.personal.petclinic.model.Speciality;
import spring.training.personal.petclinic.model.Vet;
import spring.training.personal.petclinic.services.SpecialityService;
import spring.training.personal.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(final SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(final Vet object) {

        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                        if (speciality.getId() == null) {
                            Speciality savedSpeciality = specialityService.save(speciality);
                            speciality.setId(savedSpeciality.getId());
                        }
                    }
            );
        }

        return super.save(object);
    }

    @Override
    public void delete(final Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }
}
