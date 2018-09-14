package br.eti.nogsantos.model.dao;

import br.eti.nogsantos.model.entity.Sysrole;
import br.eti.nogsantos.model.entity.Sysuser;

import java.util.List;

public interface SysuserDao {

    boolean insert(Sysuser sysuser, List<Sysrole> sysrole);

    boolean block(Sysuser sysuser);

    boolean release(Long id);

    Sysuser getByLogin(String login);

    Sysuser getById(Long id);

    List<Sysuser> listAll();

    List<Sysuser> listBlock();

    boolean loginExists(Sysuser sysuser);

    void removeUserRole(Sysuser sysuser, List<Sysrole> sysroles);

    void removeUserRole(Sysuser sysuser, Sysrole sysroles);

}
