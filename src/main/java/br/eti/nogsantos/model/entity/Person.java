package br.eti.nogsantos.model.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Fabricio Nogueira (nogsantos)
 * @since Jan 1, 2015
 */
@Entity
@Table(
        name = "person",
        schema = "administration"
)
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable {

    private static final String DB_SCHEMA = "administration";
    private static final String SEQUENCE_NAME = ".person_seq";

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

    @NotNull(
            message = "field.required"
    )
    @Length(
            min = 5,
            max = 250,
            message = "field.length"
    )
    @Column(
            name = "name",
            nullable = false,
            length = 250
    )
    private String name;

    @ElementCollection
    @CollectionTable(
            name = DB_SCHEMA + ".person_email"
    )
    @Column(
            name = "email",
            length = 250
    )
    private Set<String> emails;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
//        orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<Phone> phones;

    /**
     * private constructor for hibernate
     */
    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
