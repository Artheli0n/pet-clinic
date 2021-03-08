package spring.training.personal.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
@Data
@EqualsAndHashCode(callSuper = true, of = {})
@NoArgsConstructor
@SuperBuilder
public class PetType extends NamedEntity {

    @Override
    public String toString() {
        return super.toString();
    }
}
