
package br.eti.nogsantos.controller;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.eti.nogsantos.model.dao.SysroleDao;
import br.eti.nogsantos.model.entity.Sysrole;
import br.eti.nogsantos.rules.AuthRule;

import javax.inject.Inject;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 26, 2014
 */
@CustomBrutauthRules(AuthRule.class)
@Controller
@Path("sysrole")
public class SysroleController {
    /*
     * Object and variables
     */
    private final Result result;
    private final SysroleDao dao;
    private final Validator validator;

    /**
     * CDI only
     */
    @Deprecated
    SysroleController() {
        this(null, null, null);
    }

    /**
     * Constructor
     *
     * @param result
     * @param dao
     * @param validator
     */
    @Inject
    public SysroleController(Result result, SysroleDao dao,
                             Validator validator) {
        this.result = result;
        this.dao = dao;
        this.validator = validator;
    }

    /**
     * List
     */
    @Path("/")
    public void index() {
        this.result.include("roles", this.dao.listAll());
    }

    /**
     * Form
     */
    @Path("form")
    public void form() {
        this.result.include("form_title", "tit.insert");
    }

    /**
     * Persist data
     *
     * @param sysrole
     */
    @Path("persist")
    public void persist(Sysrole sysrole) {
        /*
         * Validate form data
         */
        this.validator.validate(sysrole);
        if (sysrole.getId() == null) {
            /*
             * Confirma se o nome já existe no sistema.
             */
            if (this.dao.nameExists(sysrole)) {
                this.validator.add(
                        new I18nMessage(
                                "return_message",
                                "return.field.exists",
                                "Name"
                        )
                );
            }
        }
        this.validator.onErrorRedirectTo(this).form();
        /*
         * Insert and update
         */
        if (!this.dao.insert(sysrole)) {
            this.result.include("return_message", "return.persistence.error");
        }
        this.result.include("return_message", "return.persistence");
        this.result.redirectTo(this).update(sysrole.getId());
    }

    /**
     * updating
     *
     * @param id
     */
    @Path("update/{id}")
    public void update(Long id) {
        this.result.include("form_title", "tit.update");
        Sysrole sysrole = this.dao.getById(id);
        if (sysrole == null) {
            /*
             * not found, redirect to 404.
             */
            this.result.notFound();
        } else {
            /*
             * Using the same form to insert.
             */
            this.result.include(sysrole);
            this.result.of(this).form();
        }
    }

    /**
     * blocking
     *
     * @param id
     */
    @Path("block/{id}")
    public void block(Long id) {

    }

}
