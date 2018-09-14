package br.eti.nogsantos.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 11, 2014
 */
@Entity
@Table(
        name = "sysuser",
        schema = "administration",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "login")
        }
)
@NamedQueries({
        @NamedQuery(
                name = Sysuser.QUERY_BY_LOGIN,
                query = "select u from Sysuser u where u.login = :login"
        ),
        @NamedQuery(
                name = Sysuser.SYSUSER_COUNT,
                query = "select count(u) from Sysuser u"
        )
})
public class Sysuser extends Person implements Serializable {

    public static final String SYSUSER_COUNT = "Sysuser.SysuserCount";
    public static final String QUERY_BY_LOGIN = "Sysuser.QueryByLogin";

    @NotNull(
            message = "field.required"
    )
    @Length(
            min = 5,
            max = 30,
            message = "field.length"
    )
    @Column(
            name = "login",
            nullable = false,
            unique = true,
            length = 30
    )
    private String login;

    @Length(
            min = 1,
            max = 92,
            message = "field.length"
    )
    @Column(
            name = "password",
            length = 92,
            updatable = false
    )
    private String password;

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
            mappedBy = "sysuser",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    private Set<SysuserRole> sysUserRoles;

    @Transient
    private Long sysuserCount;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login.toLowerCase().trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<SysuserRole> getSysUserRoles() {
        return sysUserRoles;
    }

    public void setSysUserRoles(Set<SysuserRole> sysUserRoles) {
        this.sysUserRoles = sysUserRoles;
    }

    public Long getSysuserCount() {
        return sysuserCount;
    }

    public void setSysuserCount(Long sysuserCount) {
        this.sysuserCount = sysuserCount;
    }
}
