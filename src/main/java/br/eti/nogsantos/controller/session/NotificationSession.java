package br.eti.nogsantos.controller.session;

import br.eti.nogsantos.model.entity.Sysuser;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 23, 2014
 */
@SessionScoped
@Named("notification_session")
public class NotificationSession implements Serializable {
    /*
     */
    private Sysuser sysuser;

    /**
     * Current user in session
     *
     * @param sysuser
     */
    public void sysuserSession(Sysuser sysuser) {
        this.sysuser = sysuser;
    }

    /**
     * Session user name
     *
     * @return
     */
    public String getName() {
        return this.sysuser.getName();
    }

    /**
     * Session user id
     *
     * @return
     */
    public Long getId() {
        return this.sysuser.getId();
    }

    /**
     * Check if the user is logged
     *
     * @return
     */
    public boolean isLogged() {
        return this.sysuser != null;
    }

    /**
     * Logout
     */
    public void logout() {
        this.sysuser = null;
    }
}
