package br.eti.nogsantos.model.repository;

import br.eti.nogsantos.model.dao.SysuserDao;
import br.eti.nogsantos.model.entity.Sysrole;
import br.eti.nogsantos.model.entity.Sysuser;
import br.eti.nogsantos.model.entity.SysuserRole;
import org.apache.shiro.authc.credential.PasswordService;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Transactional
@RequestScoped
public class SysuserRepository extends SystemRepository implements SysuserDao {
    /*
     * Objects and variables
     */
    @Inject
    private PasswordService passwordService;
    private String sqlTable = "administration.sysuser";

    /**
     * Inserting
     *
     * @param sysuser
     * @param sysroles
     * @return boolean if success
     */
    @Override
    public boolean insert(Sysuser sysuser, List<Sysrole> sysroles) {
        try {
            /*
             * Encripting the password sha256
             */
            sysuser.setPassword(
                    passwordService.encryptPassword(sysuser.getPassword())
            );
            /*
             * Removing empty email values
             */
            sysuser.getEmails().removeAll(Collections.singleton(null));
            removeUserRole(sysuser, sysroles);
            if (sysuser.getId() == null) {
                doInsert(sysuser);
            } else {
                doUpdate(sysuser);
            }
            insertUserRole(sysuser, sysroles);
            return true;
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
            return false;
        }
    }

    /**
     * Insert action
     */
    private void doInsert(Sysuser sysuser) {
        sysuser.setDtCadastre(Calendar.getInstance());
        this.session.save(sysuser);
    }

    /**
     * Update action
     */
    private void doUpdate(Sysuser sysuser) {
        this.session.merge(sysuser);
        this.session.flush();
        dtUpdate(sysuser.getId(), this.sqlTable);
    }

    /**
     * Insert user roles
     */
    private void insertUserRole(Sysuser sysuser, List<Sysrole> sysroles) {
        if (sysroles != null) {
            try {
                for (Sysrole role : sysroles) {
                    SysuserRole sur = new SysuserRole(sysuser, role);
                    sur.setSysrole(role);
                    sur.setSysuser(sysuser);
                    this.session.save(sur);
                }
            } catch (HibernateException e) {
                this.log.error(e.getMessage());
            }
        }
    }

    /**
     * Removing user roles
     *
     * @param sysuser
     * @param sysroles
     */
    @Override
    public void removeUserRole(Sysuser sysuser, List<Sysrole> sysroles) {
        if (sysroles != null) {
            try {
                for (Sysrole role : sysroles) {
                    SysuserRole sur = new SysuserRole(sysuser, role);
                    sur.setSysrole(role);
                    sur.setSysuser(sysuser);
                    this.session.delete(sur);
                }
            } catch (Exception e) {
                this.log.error(e.getMessage());
            }
        }
    }

    /**
     * Removing user roles
     *
     * @param sysuser
     * @param sysroles
     */
    @Override
    public void removeUserRole(Sysuser sysuser, Sysrole sysroles) {
        try {
            SysuserRole sur = new SysuserRole(sysuser, sysroles);
            this.session.delete(sur);
        } catch (Exception e) {
            this.log.error(e.getMessage());
        }
    }

    /**
     * Blocking
     *
     * @param sysuser
     * @return boolean
     */
    @Override
    public boolean block(Sysuser sysuser) {
        return doBlock(sysuser.getId(), this.sqlTable);
    }

    /**
     * Releasing
     *
     * @param id
     * @return boolean
     */
    @Override
    public boolean release(Long id) {
        return doRelease(id, this.sqlTable);
    }

    /**
     * Getting system user by login.
     *
     * @param login
     * @return Object
     */
    @Override
    public Sysuser getByLogin(String login) {
        try {
            return (Sysuser) createCriteria(Sysuser.class)
                    .add(Restrictions.eq("login", login))
                    .uniqueResult();
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
            return null;
        }
    }

    /**
     * Getting by id
     *
     * @param id
     * @return Object
     */
    @Override
    public Sysuser getById(Long id) {
        try {
            return (Sysuser) this.session.get(Sysuser.class, id);
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
            return null;
        }
    }

    /**
     * List all where is not blocked
     *
     * @return Object
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Sysuser> listAll() {
        try {
            Criteria listall = createCriteria(Sysuser.class);
            listall.add(Restrictions.isNull("dtBlock"));
            listall.addOrder(Order.desc("dtCadastre"));
//            listall.setMaxResults(1);
//            listall.setFirstResult(0);
            return listall.list();
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
            return null;
        }
    }

    /**
     * List all where is not blocked
     *
     * @return Object
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Sysuser> listBlock() {
        try {
            Criteria listall = createCriteria(Sysuser.class);
            listall.add(Restrictions.isNotNull("dtBlock"));
            listall.addOrder(Order.desc("dtBlock"));
            return listall.list();
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
            return null;
        }
    }

    /**
     * Check if informed login exists
     *
     * @param sysuser
     * @return boolean
     */
    @Override
    public boolean loginExists(Sysuser sysuser) {
        try {
            Criteria crit = createCriteria(Sysuser.class);
            crit.add(Restrictions.eq("login", sysuser.getLogin()));
            return crit.list().size() >= 1;
        } catch (Exception e) {
            this.log.error(e.getMessage());
            return false;
        }
    }
}