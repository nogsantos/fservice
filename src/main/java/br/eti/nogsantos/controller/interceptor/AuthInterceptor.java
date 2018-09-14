
package br.eti.nogsantos.controller.interceptor;

import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.eti.nogsantos.controller.IndexController;
import br.eti.nogsantos.controller.session.SysuserSession;
import br.eti.nogsantos.model.repository.SysuserRepository;
import freemarker.log.Logger;

import javax.inject.Inject;

/**
 * ///////////////////////////////// Apenas para testes!
 *
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 23, 2014
 */
//@Intercepts
public class AuthInterceptor {
    /*
     * Class objects
     */
    private Logger log = Logger.getLogger(SysuserRepository.class.getName());
    private SysuserSession sysuserSession;
    private Result result;

    /**
     * CDI only
     */
    @Deprecated
    AuthInterceptor() {
    }

    /**
     * Inject constructor
     *
     * @param sysuserSession
     * @param result
     */
    @Inject
    public AuthInterceptor(SysuserSession sysuserSession, Result result) {
        this.sysuserSession = sysuserSession;
        this.result = result;
    }

    /**
     * Check if the user is logged
     *
     * @param stack
     */
    @AroundCall
    public void auth(SimpleInterceptorStack stack) {
        if (this.sysuserSession.isLogged()) {
            stack.next();
        } else {
            this.result.include("return_message", "alert.do.the.login");
            this.result.redirectTo(IndexController.class).index();
        }
    }

    /**
     * Allow public class.
     * do not intercept the class with public notations.
     *
     * @param method
     * @return
     */
    @Accepts
    public boolean isPublic(ControllerMethod method) {
        return method.containsAnnotation(Public.class);
    }
}
