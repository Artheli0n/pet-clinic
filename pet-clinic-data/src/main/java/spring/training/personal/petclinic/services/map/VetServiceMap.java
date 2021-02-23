package spring.training.personal.petclinic.services.map;

import spring.training.personal.petclinic.model.Vet;
import spring.training.personal.petclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
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
        return super.save(object.getId(), object);
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
