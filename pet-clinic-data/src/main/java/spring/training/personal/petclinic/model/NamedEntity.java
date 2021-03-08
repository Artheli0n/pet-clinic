package spring.training.personal.petclinic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true, of = {})
public class NamedEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return this.getName();
    }

}
