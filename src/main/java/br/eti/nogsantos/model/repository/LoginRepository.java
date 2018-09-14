
package br.eti.nogsantos.model.repository;

import br.eti.nogsantos.model.dao.LoginDao;
import br.eti.nogsantos.model.entity.Sysuser;
import freemarker.log.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Set;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 23, 2014
 */
@Transactional
@RequestScoped
public class LoginRepository implements LoginDao {
    /*
     * Objects and variables
     */
    @Inject
    private Session session;
    private Logger log = Logger.getLogger(SysuserRepository.class.getName());

    /**
     * Criteria
     */
    private Criteria createCriteria() {
        return this.session.createCriteria(Sysuser.class);
    }

    /**
     * Query system user by login and date block is null.
     * This method is used by vraptor-shiro project
     * https://github.com/dipold/vraptor-shiro/wiki
     *
     * @param login
     * @return
     */
    @Override
    public Sysuser getSysuserByLogin(String login) {
        try {
            return (Sysuser) createCriteria()
                    .add(Restrictions.eq("login", login))
                    .add(Restrictions.isNull("dtBlock"))
                    .uniqueResult();
        } catch (Exception e) {
            this.log.error(e.getMessage());
            return null;
        }
    }

    /**
     * Implement user role
     *
     * @param login
     * @return
     */
    @Override
    public Set<String> getRoleByLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implement permission by role
     *
     * @param login
     * @return
     */
    @Override
    public Set<String> getPermissionByRole(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
