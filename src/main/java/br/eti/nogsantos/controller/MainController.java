package br.eti.nogsantos.controller;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.eti.nogsantos.rules.AuthRule;

import javax.inject.Inject;

/**
 * Main controller
 *
 * @author Fabricio Nogueira
 * @since 18 Dec 2014
 */
@CustomBrutauthRules(AuthRule.class)
@Controller
@Path("main")
public class MainController {
    /*
     * Class objects
     */
    private final Result result;

    /**
     * CDI only
     */
    @Deprecated
    MainController() {
        this(null);
    }

    /**
     * Constructor
     *
     * @param result
     */
    @Inject
    public MainController(Result result) {
        this.result = result;
    }

    /**
     * Index
     */
    @Path("/")
    public void index() {

    }
}