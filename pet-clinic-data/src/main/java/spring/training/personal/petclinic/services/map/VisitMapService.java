package spring.training.personal.petclinic.services.map;

import spring.training.personal.petclinic.model.Visit;
import spring.training.personal.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(final Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(final Visit visit) {

        if (visit.getPet() == null || visit.getPet().getOwner() == null | visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit Parameters");
        }

        return super.save(visit);
    }

    @Override
    public void delete(final Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
        super.deleteById(aLong);
    }

//    @Override
//    public Set<Visit> findByPetId(final Long petId) {
//
//        // TODO
//        return null;
//    }
}
