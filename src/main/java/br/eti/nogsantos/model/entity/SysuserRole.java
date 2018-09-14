package br.eti.nogsantos.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Jan 8, 2015
 */
@Entity
@Table(
        name = "sys_user_role",
        schema = "administration"
)
public class SysuserRole implements Serializable {

    private static final String DB_SCHEMA = "administration";
    private static final String SEQUENCE_NAME = ".sys_user_role_seq";

    @Id
    @ManyToOne
    @JoinColumn(name = "sysuser_id")
    private Sysuser sysuser;

    @Id
    @ManyToOne
    @JoinColumn(name = "sysrole_id")
    private Sysrole sysrole;

    /**
     * private constructor for hibernate
     */
    private SysuserRole() {
    }

    /**
     * @param sysuser
     * @param sysrole
     */
    public SysuserRole(Sysuser sysuser, Sysrole sysrole) {
        this.sysuser = sysuser;
        this.sysrole = sysrole;
    }

    public Sysuser getSysuser() {
        return sysuser;
    }

    public void setSysuser(Sysuser sysuser) {
        this.sysuser = sysuser;
    }

    public Sysrole getSysrole() {
        return sysrole;
    }

    public void setSysrole(Sysrole sysrole) {
        this.sysrole = sysrole;
    }
}
