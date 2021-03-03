package spring.training.personal.petclinic.services.jpa;

import spring.training.personal.petclinic.model.Owner;
import spring.training.personal.petclinic.repositories.OwnerRepository;
import spring.training.personal.petclinic.repositories.PetRepository;
import spring.training.personal.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    private static final Long OWNER_ID = 1L;
    public static final String LAST_NAME = "Smith";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    // automatically injects mocks to construct it
    @InjectMocks
    OwnerJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(OWNER_ID).build();
    }

    @Test
    void findAll() {

        Set<Owner> owners = new HashSet<>();
        owners.add(returnOwner);
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        assertEquals(owners, service.findAll());
        // note: default is 1 times so times not needed here
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        final Owner owner = service.findById(OWNER_ID);
        assertEquals(returnOwner, owner);
        verify(ownerRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByIdNotFound() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        final Owner owner = service.findById(OWNER_ID);
        assertNull(owner);
        verify(ownerRepository, times(1)).findById(anyLong());
    }

    @Test
    void save() {

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        assertEquals(returnOwner, service.save(returnOwner));
        verify(ownerRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(OWNER_ID);

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(Optional.of(returnOwner));

        Owner smith = service.findByLastName(LAST_NAME);

        assertNotNull(smith);
        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository, times(1)).findByLastName(anyString());
    }
}
