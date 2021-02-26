package spring.training.personal.petclinic.bootstrap;

import spring.training.personal.petclinic.model.Owner;
import spring.training.personal.petclinic.model.Pet;
import spring.training.personal.petclinic.model.PetType;
import spring.training.personal.petclinic.model.Vet;
import spring.training.personal.petclinic.services.OwnerService;
import spring.training.personal.petclinic.services.PetTypeService;
import spring.training.personal.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(final OwnerService ownerService,
                      final VetService vetService,
                      final PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(final String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setPhoneNumber("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setName("Rex");
        mikesPet.setType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setPhoneNumber("1231231234");

        Pet fionasPet = new Pet();
        fionasPet.setName("Catty");
        fionasPet.setOwner(owner2);
        fionasPet.setType(savedCatPetType);
        fionasPet.setBirthDate(LocalDate.now().minusDays(3));
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
