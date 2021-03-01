package spring.training.personal.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

// this is used to say that the entity is never going to be instantiated on its own but will be inherited by other entities
// so there is no need to create a table for this
@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
}
