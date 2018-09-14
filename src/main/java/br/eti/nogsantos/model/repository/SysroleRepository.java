package br.eti.nogsantos.model.repository;

import br.eti.nogsantos.model.dao.SysroleDao;
import br.eti.nogsantos.model.entity.Sysrole;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

/**
 * @author Fabricio Nogueira (nogsantos)
 * @since Dec 26, 2014
 */
@Transactional
@RequestScoped
public class SysroleRepository extends SystemRepository implements SysroleDao {
    /**
     */
    private String sqlTable = "administration.sysrole";

    /**
     * Inserting
     *
     * @param sysrole
     * @return boolean if success
     */
    @Override
    public boolean insert(Sysrole sysrole) {
        try {
            if (sysrole.getId() == null) {
                sysrole.setDtCadastre(Calendar.getInstance());
                this.session.save(sysrole);
            } else {
                this.session.merge(sysrole);
                this.session.flush();
                dtUpdate(sysrole.getId(), this.sqlTable);
            }
            return true;
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
            return false;
        }
    }

    /**
     * block roles
     *
     * @param sysrole
     * @return boolean
     */
    @Override
    public boolean block(Sysrole sysrole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Release roles
     *
     * @param id
     * @return boolean
     */
    @Override
    public boolean release(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get role by id
     *
     * @param id
     * @return Sysrole
     */
    @Override
    public Sysrole getById(Long id) {
        try {
            return (Sysrole) this.session.get(Sysrole.class, id);
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
            return null;
        }
    }

    /**
     * Check if the informed name already exist on database.
     *
     * @param sysrole
     * @return boolean
     */
    @Override
    public boolean nameExists(Sysrole sysrole) {
        try {
            Criteria crit = createCriteria(Sysrole.class);
            crit.add(Restrictions.eq("name", sysrole.getName()));
            return crit.list().size() >= 1;
        } catch (Exception e) {
            this.log.error(e.getMessage());
            return false;
        }
    }

    /**
     * List all roles
     *
     * @return List
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Sysrole> listAll() {
        try {
            Criteria listall = createCriteria(Sysrole.class);
            listall.add(Restrictions.isNull("dtBlock"));
            listall.addOrder(Order.desc("dtCadastre"));
            return listall.list();
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
            return null;
        }
    }

    /**
     * Query not related roles by user.
     *
     * @param userId
     * @return Sysrole
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Sysrole> queryRolesDoNotRelateByUser(Long userId) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" select distinct ");
            stringBuilder.append(" r ");
            stringBuilder.append(" from Sysrole r ");
            stringBuilder.append(" where r.id not in ( ");
            stringBuilder.append(" select sr.sysrole.id from SysuserRole sr ");
            stringBuilder.append(" where sr.sysuser.id = :userId ");
            stringBuilder.append(" ) ");
            Query query = this.session.createQuery(stringBuilder.toString());
            query.setParameter("userId", userId);
            List<Sysrole> sysroles = query.list();
            return sysroles;
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
            return null;
        }
    }

    /**
     * List all block roles
     *
     * @return List
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Sysrole> listBlock() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
