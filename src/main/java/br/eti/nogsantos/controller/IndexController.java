package br.eti.nogsantos.controller;

import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.security.AuthorizationRestrictionListener;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.eti.nogsantos.controller.session.SysuserSession;
import br.eti.nogsantos.model.dao.SysuserDao;
import br.eti.nogsantos.model.entity.Sysuser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;

import javax.inject.Inject;
import java.util.Calendar;

/**
 * Authentication by vraptor-shiro project.
 * https://github.com/dipold/vraptor-shiro/
 *
 * @author Fabricio Nogueira
 * @since 23 Dec 2014
 */
@Public
@Controller
@Path("/")
public class IndexController implements AuthorizationRestrictionListener {
    /*
     * Class objects
     */
    private final Result result;
    private final Validator validator;
    private final SysuserDao dao;
    private final Subject subject;
    private final SysuserSession session;

    /**
     * CDI only
     */
    @Deprecated
    IndexController() {
        this(null, null, null, null, null);
    }

    /**
     * Inject constructor
     *
     * @param result
     * @param validator
     * @param dao
     * @param subject
     * @param session
     */
    @Inject
    public IndexController(Result result, Validator validator, SysuserDao dao,
                           Subject subject, SysuserSession session) {
        this.result = result;
        this.validator = validator;
        this.dao = dao;
        this.subject = subject;
        this.session = session;
    }

    /**
     * Login form
     */
    @Path("/")
    public void index() {
        result.include("current_year", Calendar.getInstance().get(Calendar.YEAR));
    }

    /**
     * Do login using vraptor-shiro project
     *
     * @param sysuser
     */
    @Post("dologin")
    public void doLogin(Sysuser sysuser) {
        try {
            this.subject.login(
                    new UsernamePasswordToken(
                            sysuser.getLogin(),
                            sysuser.getPassword()
                    )
            );
            /*
             * putting Session values
             */
            this.session.sysuserSession(this.dao.getByLogin(sysuser.getLogin()));
            /*
             * Redirectiong
             */
            this.result.redirectTo(MainController.class).index();
        } catch (UnknownAccountException | LockedAccountException | ExcessiveAttemptsException e) {
            /*
             * [Erro desconhecido da conta]
             * [Conta bloqueada]
             * [Muitas tentativas de login]
             *
             * Não retorna mensagem de erro para o usuário.
             */
            this.result.redirectTo(IndexController.class).index();
        } catch (IncorrectCredentialsException e) {
            /*
             * Usuário existe, porém a senha está errada
             */
            this.result.include("return_message", "return.login_failed");
            this.result.redirectTo(IndexController.class).index();
        } catch (AuthenticationException e) {
            /*
             * Usuário não existe no sistema
             */
            this.result.include("return_message", "return.login_failed");
            this.result.redirectTo(IndexController.class).index();
        }
    }

    /**
     * Do the logout
     */
    @Get("logout")
    public void logout() {
        this.subject.logout();
        this.session.logout();
        this.result.redirectTo(this).index();
    }

    /**
     * @param e
     */
    @Override
    public void onAuthorizationRestriction(AuthorizationException e) {
        result.include("return_message", e.toString());
        result.use(Results.status()).forbidden(e.toString());
    }
}
