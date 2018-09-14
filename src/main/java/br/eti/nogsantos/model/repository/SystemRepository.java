package br.eti.nogsantos.model.repository;

import freemarker.log.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.inject.Inject;
import java.util.Calendar;

/**
 * @author Fabricio Nogueira (nogsantos)
 * @since Dec 26, 2014
 */
public abstract class SystemRepository {
    /*
     * Objects and variables
     */
    @Inject
    protected Session session;
    protected Logger log = Logger.getLogger(SystemRepository.class.getName());

    /**
     * Criteria to perform queries.
     *
     * @param fClass
     * @return
     */
    protected Criteria createCriteria(Class<?> fClass) {
        return this.session.createCriteria(fClass);
    }

    /**
     * method to update date update
     *
     * @param id
     * @param table
     */
    protected void dtUpdate(Long id, String table) throws HibernateException {
        try {
            String hql = " UPDATE " + table + " set dt_update = :dtUpdate " +
                    " WHERE id = :sysuser_id ";
            Query query = session.createSQLQuery(hql);
            query.setParameter("dtUpdate", Calendar.getInstance());
            query.setParameter("sysuser_id", id);
            query.executeUpdate();
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
        }
    }

    /**
     * Block default action.
     *
     * @param id
     * @param table
     * @return
     */
    protected boolean doBlock(Long id, String table) throws HibernateException {
        try {
            String hql = " UPDATE " + table + " set dt_block = :dtBlock " +
                    " WHERE id = :sysuser_id ";
            Query query = session.createSQLQuery(hql);
            query.setParameter("dtBlock", Calendar.getInstance());
            query.setParameter("sysuser_id", id);
            query.executeUpdate();
            dtUpdate(id, table);
            return true;
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
            return false;
        }
    }

    /**
     * Releasing
     *
     * @param id
     * @param table
     * @return boolean
     */
    protected boolean doRelease(Long id, String table) throws HibernateException {
        try {
            String hql = " UPDATE " + table + " set dt_block = null " +
                    " WHERE id = :sysuser_id ";
            Query query = this.session.createSQLQuery(hql);
            query.setParameter("sysuser_id", id);
            query.executeUpdate();
            dtUpdate(id, table);
            return true;
        } catch (HibernateException e) {
            this.log.error(e.getMessage());
            return false;
        }
    }
}
