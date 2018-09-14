package br.eti.nogsantos.controller.auth;

import br.com.caelum.vraptor.security.Permission;
import br.com.caelum.vraptor.security.User;
import br.eti.nogsantos.model.dao.LoginDao;
import br.eti.nogsantos.model.entity.Sysuser;

import javax.inject.Inject;
import java.util.Collections;
import java.util.Set;

/**
 * A interface serve para fazer a ponte entre os dados dos usuários
 * que estão disponíveis no banco de dados.
 *
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 23, 2014
 */
public class Auth implements Permission {
    /*
     * Class object
     */
    @Inject
    LoginDao loginDao;

    /**
     * Do login
     *
     * @param login
     * @return
     */
    @Override
    public User getUserByUsername(String login) {
        Sysuser usuario = loginDao.getSysuserByLogin(login);
        return new User(usuario.getLogin(), usuario.getPassword());
    }

    /**
     * User role
     *
     * @param login
     * @return
     */
    @Override
    public Set<String> getRolesByUser(String login) {
        return Collections.singleton("admin");
    }

    /**
     * Get permissions by role
     *
     * @param role
     * @return
     */
    @Override
    public Set<String> getPermissionsByRole(String role) {
        return loginDao.getPermissionByRole(role);
    }
}
