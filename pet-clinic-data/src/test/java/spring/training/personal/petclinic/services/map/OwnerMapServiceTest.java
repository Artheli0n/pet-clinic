package spring.training.personal.petclinic.services.map;

import spring.training.personal.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    private static final Long OWNER_ID = 1L;

    @BeforeEach
    void setUp() {

        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(OWNER_ID).lastName("Smith").build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertNotNull(ownerSet);
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {

        Owner owner = ownerMapService.findById(OWNER_ID);

        assertNotNull(owner);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void saveExistingId() {
        final long id = 2L;
        Owner owner = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(id, savedOwner.getId() );
    }

    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();

        Owner savedOwner = ownerMapService.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId() );
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(OWNER_ID));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OWNER_ID);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName("Smith");

        assertNotNull(smith);
        assertEquals(OWNER_ID, smith.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = ownerMapService.findByLastName("foo");

        assertNull(smith);
    }
}
