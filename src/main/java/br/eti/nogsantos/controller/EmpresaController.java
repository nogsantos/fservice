package br.eti.nogsantos.controller;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.eti.nogsantos.model.dao.EmpresaDao;
import br.eti.nogsantos.rules.AuthRule;

import javax.inject.Inject;

import static br.com.caelum.vraptor.view.Results.xml;

/**
 * Main controller
 *
 * @author Fabricio Nogueira
 * @since
 */
@CustomBrutauthRules(AuthRule.class)
@Controller
@Path("/empresa")
public class EmpresaController {
    /*
     */
    private final Result result;
    private final EmpresaDao empresa;

    /**
     * CDI
     */
    @Deprecated
    EmpresaController() {
        this(null, null);
    }

    /**
     * Constructor
     *
     * @param result
     * @param empresa
     */
    @Inject
    public EmpresaController(Result result, EmpresaDao empresa) {
        this.result = result;
        this.empresa = empresa;
    }

    /**
     *
     */
    @Get
    @Path("/jsonlist")
    public void listAll() {
        result.use(Results.json())
                .withoutRoot()
                .from(empresa.listagem())
                .serialize();
    }

    /**
     *
     */
    @Get
    @Path("/xmllist")
    @Public
    public void listAllxml() {
        result.use(xml())
                .from(empresa.listagem())
                .serialize();
    }

    @Path("form")
    public void form() {

    }
}