
package br.eti.nogsantos.controller;

import br.com.caelum.vraptor.Result;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Jan 15, 2015
 */
//@Controller
//@Path("notification")
public class NotificationController {
    /*
     * Class objects
     */
    private final Result result;

    @Deprecated
    NotificationController() {
        this.result = null;
    }

    public NotificationController(Result result) {
        this.result = result;
    }


    public String sysNotify() {
        return "Yep";
    }
}
