
package br.eti.nogsantos.model.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 26, 2014
 */
@Entity
@Table(
        name = "sysrole",
        schema = "administration"
)
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
public class Sysrole implements Serializable {

    private static final String DB_SCHEMA = "administration";
    private static final String SEQUENCE_NAME = ".sysrole_seq";

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

    @Column(
            name = "dt_cadastre",
            updatable = false
    )
    @Temporal(
            TemporalType.TIMESTAMP
    )
    private Calendar dtCadastre;

    @Column(
            name = "dt_block",
            insertable = false
    )
    @Temporal(
            TemporalType.TIMESTAMP
    )
    private Calendar dtBlock;

    @Column(
            name = "dt_update",
            insertable = false
    )
    @Temporal(
            TemporalType.TIMESTAMP
    )
    private Calendar dtUpdate;

    @OneToMany(
            mappedBy = "sysrole"
    )
    private Collection<SysuserRole> sysUserRoles;

    @Column(
            name = "description",
            nullable = true
    )
    @Type(
            type = "text"
    )
    private String description;

    /**
     * private constructor for hibernate
     */
    private Sysrole() {
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

    public Calendar getDtCadastre() {
        return dtCadastre;
    }

    public void setDtCadastre(Calendar dtCadastre) {
        this.dtCadastre = dtCadastre;
    }

    public Calendar getDtBlock() {
        return dtBlock;
    }

    public void setDtBlock(Calendar dtBlock) {
        this.dtBlock = dtBlock;
    }

    public Calendar getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Calendar dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public Collection<SysuserRole> getSysUserRoles() {
        return sysUserRoles;
    }

    public void setSysUserRoles(Collection<SysuserRole> sysUserRoles) {
        this.sysUserRoles = sysUserRoles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
