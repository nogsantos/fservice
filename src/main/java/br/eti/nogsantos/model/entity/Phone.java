
package br.eti.nogsantos.model.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * This entity is related with person entity
 *
 * @author Fabricio Nogueira - nogsantos
 * @since Jan 6, 2015
 */
@Entity
@Table(
        name = "person_phone",
        schema = "administration"
)
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
public class Phone implements Serializable {

    private static final String DB_SCHEMA = "administration";
    private static final String SEQUENCE_NAME = ".person_phone_seq";

    @Id
    @SequenceGenerator(
            name = DB_SCHEMA + SEQUENCE_NAME,
            sequenceName = DB_SCHEMA + SEQUENCE_NAME,
            initialValue = 5,
            allocationSize = 5,
            schema = DB_SCHEMA
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = DB_SCHEMA + SEQUENCE_NAME
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    /**
     * Defines the phone type like Mobile, Work, Home etc...
     */
    @Column(
            name = "type",
            length = 50
    )
    private String type;
    /**
     * Define the phone carrier like Vivo, Oi etc..
     */
    @Column(
            name = "carrier",
            length = 50
    )
    private String carrier;

    @NotNull(
            message = "field.required"
    )
    @Length(
            min = 8,
            max = 20,
            message = "field.length"
    )
    @Column(
            name = "number",
            nullable = false,
            length = 20
    )
    private String number;

    @ManyToOne
    @JoinColumn(
            name = "person_id"
    )
    private Person person;

    /**
     * private constructor for hibernate
     */
    private Phone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
