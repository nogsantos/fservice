package br.eti.nogsantos.model.repository;

import br.eti.nogsantos.model.dao.EmpresaDao;
import br.eti.nogsantos.model.entity.Empresa;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class EmpresaRepository implements EmpresaDao {

    @Inject
    private Session session;

    private Criteria createCriteria() {
        return session.createCriteria(Empresa.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Empresa> listagem() {
        return createCriteria().list();
    }
}
