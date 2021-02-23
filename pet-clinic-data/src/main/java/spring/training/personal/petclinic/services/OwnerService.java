package spring.training.personal.petclinic.services;

import spring.training.personal.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
