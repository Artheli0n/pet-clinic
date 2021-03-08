package spring.training.personal.petclinic.services.map;

import spring.training.personal.petclinic.model.Owner;
import spring.training.personal.petclinic.model.Pet;
import spring.training.personal.petclinic.services.OwnerService;
import spring.training.personal.petclinic.services.PetService;
import spring.training.personal.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(final PetTypeService petTypeService, final PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(final Owner object) {

        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                            if (pet.getType() != null) {
                                if (pet.getType().getId() == null) {
                                    pet.setType(petTypeService.save(pet.getType()));
                                }
                            } else {
                                throw new RuntimeException("Pet Type is required");
                            }

                            if (pet.getId() == null) {
                                Pet savedPet = petService.save(pet);
                                pet.setId(savedPet.getId());
                            }
                        }
                );
            }

            return super.save(object);
        } else {
            return null;
        }

    }

    @Override
    public void delete(final Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameContaining(final String lastName) {

        // TODO
        return null;
    }
}
