
package br.eti.nogsantos.rules;

import br.com.caelum.brutauth.auth.rules.CustomBrutauthRule;
import br.com.caelum.brutauth.reflection.BrutauthValidation;
import br.eti.nogsantos.controller.session.SysuserSession;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Custom Brutauth rules
 *
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 26, 2014
 */
@RequestScoped
public class AuthRule implements CustomBrutauthRule {
    /*
     * Class objects
     */
    private SysuserSession sysuserSession;

    /**
     * CDI
     */
    @Deprecated
    AuthRule() {
    }

    /**
     * Class constructor
     *
     * @param sysuserSession
     */
    @Inject
    public AuthRule(SysuserSession sysuserSession) {
        this.sysuserSession = sysuserSession;
    }

    /**
     * Verify if is a user logged.
     *
     * @return boolean
     */
    @BrutauthValidation
    public boolean isLoggedIn() {
        return sysuserSession.isLogged();
    }
}
