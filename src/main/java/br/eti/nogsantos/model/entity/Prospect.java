package br.eti.nogsantos.model.entity;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 11, 2014
 */
@Entity
@Table(
        name = "prospect",
        schema = "business"
)
public class Prospect extends Person implements Serializable {

    @NotNull(
            message = "field.required"
    )
    @Length(
            min = 5,
            max = 30,
            message = "field.length"
    )
    @Column(
            name = "contact",
            nullable = false,
            length = 30
    )
    private String contact;

    @Column(
            name = "observation",
            nullable = true
    )
    @Type(
            type = "text"
    )
    private String observation;

    /**
     * private constructor for hibernate
     */
    private Prospect() {
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
