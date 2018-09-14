
package br.eti.nogsantos.controller.interceptor;

import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.eti.nogsantos.controller.NotificationController;

import javax.inject.Inject;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Jan 15, 2015
 */
@Intercepts
public class NotificationInterceptor implements Interceptor {

    private Result result;
    private NotificationController notification;

    @Deprecated
    NotificationInterceptor() {
    }

    @Inject
    public NotificationInterceptor(Result result
            , NotificationController notification
    ) {
        this.result = result;
        this.notification = notification;
    }

    @Override
    public void intercept(InterceptorStack is,
                          ControllerMethod cm, Object o) throws InterceptionException {

        this.result.include("notification", this.notification.sysNotify());
    }

    @Override
    public boolean accepts(ControllerMethod cm) {
        return cm.containsAnnotation(Public.class);
    }

}
