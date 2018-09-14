package br.eti.nogsantos.controller;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.eti.nogsantos.model.dao.SysroleDao;
import br.eti.nogsantos.model.dao.SysuserDao;
import br.eti.nogsantos.model.entity.Sysrole;
import br.eti.nogsantos.model.entity.Sysuser;
import br.eti.nogsantos.rules.AuthRule;

import javax.inject.Inject;
import java.util.List;

/**
 * System user controller
 *
 * @author Fabricio Nogueira
 * @since 18 Dec 2014
 */
@CustomBrutauthRules(AuthRule.class)
@Controller
@Path("sysuser")
public class SysuserController {
    /*
     * Object and variables
     */
    private final Result result;
    private final SysuserDao dao;
    private final Validator validator;
    private final SysroleDao role;

    /**
     * CDI only
     */
    @Deprecated
    SysuserController() {
        this(null, null, null, null);
    }

    /**
     * Constructor
     *
     * @param result
     * @param sysuser
     * @param validator
     * @param sysrole
     */
    @Inject
    public SysuserController(Result result, SysuserDao sysuser,
                             Validator validator, SysroleDao sysrole) {
        this.result = result;
        this.dao = sysuser;
        this.validator = validator;
        this.role = sysrole;
    }

    /**
     * index
     */
    @Path("/")
    public void index() {
        /*
         * Duas formas diferentes de disponibilizar um objeto para o conteúdo jsp:
         * ~> via return
         *      o objeto listado terá o nome de sysuserList [nomedaclaseList]
         *      é possivel apenas um retorno de objeto no jsp.
         * ~> via result
         *      o nome pode ser escolhido.
         *      quantos forem necessários.
         */
        this.result.include("users", this.dao.listAll());
        // Alterar o retorno para: List<Sysuser>
        // return this.dao.listAll();
    }

    /**
     * index
     */
    @Path("blocklist")
    public void blocklist() {
        this.result.include("blockusers", this.dao.listBlock());
    }

    /**
     * Form
     */
    @Path("form")
    public void form() {
        /*
         * form title
         */
        this.result.include("form_title", "tit.insert");
        /*
         * form roles
         */
        this.result.include("roles", this.role.listAll());
    }

    /**
     * Insert method
     *
     * @param sysuser
     * @param sysrole
     */
    @Path("persist")
    public void persist(Sysuser sysuser, List<Sysrole> sysrole) {
        /*
         * Validate form data
         */
        this.validator.validate(sysuser);
        if (sysuser.getId() == null) {
            /*
             * Confirma se o login já existe no sistema.
             */
            if (this.dao.loginExists(sysuser)) {
                this.validator.add(new I18nMessage(
                                "return_message",
                                "return.field.exists",
                                "Login"
                        )
                );
            }
        }
        this.validator.onErrorRedirectTo(this).form();
        /*
         * Insert or update
         */
        if (!this.dao.insert(sysuser, sysrole)) {
            this.result.include("return_message", "return.persistence.error");
        }
        this.result.include("return_message", "return.persistence");
        this.result.redirectTo(this).update(sysuser.getId());
    }

    /**
     * Edit method
     *
     * @param id
     */
    @Path("update/{id}")
    public void update(Long id) {
        /*
         * form title
         */
        this.result.include("form_title", "tit.update");
        /*
         * not related role by user
         */
        this.result.include("roles", this.role.queryRolesDoNotRelateByUser(id));
        /*
         * Loading the user
         */
        Sysuser sysuser = this.dao.getById(id);
        if (sysuser == null) {
            /*
             * not found, redirect to 404.
             */
            this.result.notFound();
        } else {
            /*
             * Using the same form to insert.
             */
            this.result.include(sysuser);
            this.result.of(this).form();
        }
    }

    /**
     * Block form
     *
     * @param id
     */
    @Path("block/{id}")
    public void block(Long id) {
        Sysuser sysuser = this.dao.getById(id);
        if (sysuser == null) {
            this.result.notFound();
        } else {
            this.result.include(sysuser);
            this.result.include("form_title", "tit.block");
        }
    }

    /**
     * Release user
     *
     * @param id
     */
    @Path("release/{id}")
    public void release(Long id) {
        Sysuser sysuser = this.dao.getById(id);
        if (sysuser == null) {
            this.result.notFound();
        } else {
            if (this.dao.release(id)) {
                this.result.include("return_message", "return.release");
                this.result.redirectTo(this).index();
            } else {
                this.result.include("return_message", "return.release.error");
                this.result.redirectTo(this).blocklist();
            }
        }
    }

    /**
     * Block action
     *
     * @param sysuser
     */
    @Path("blockaction")
    public void blockaction(Sysuser sysuser) {
        if (this.dao.getById(sysuser.getId()) == null) {
            this.result.notFound();
        } else {
            if (this.dao.block(sysuser)) {
                this.result.include("return_message", "return.block");
            } else {
                this.result.include("return_message", "return.block.error");
            }
            this.result.redirectTo(this).index();
        }
    }

    /**
     * json example
     */
    @Path("getjson")
    public void getJson() {
        result.use(Results.json())
                .withoutRoot()
                .from(this.dao.listAll())
                .serialize();
    }

    /**
     * list all
     */
    @Path("list")
    public void list() {
        result.use(Results.json())
                .withoutRoot()
                .from(this.dao.listAll())
                .serialize();

    }

    /**
     * @param userId
     * @param roleId
     */
    @Delete("deleterolebyuser/{userId}/{roleId}")
    public void deleterolebyuser(Long userId, Long roleId) {
        Sysuser sysuser = this.dao.getById(userId);
        Sysrole sysrole = this.role.getById(roleId);
        this.dao.removeUserRole(sysuser, sysrole);
        result.use(
                Results.json()
        )
                .withoutRoot()
                .from("ok")
                .serialize();
    }

}
