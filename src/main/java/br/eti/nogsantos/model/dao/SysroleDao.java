package br.eti.nogsantos.model.dao;

import br.eti.nogsantos.model.entity.Sysrole;

import java.util.List;


public interface SysroleDao {

    boolean insert(Sysrole sysrole);

    boolean block(Sysrole sysrole);

    boolean release(Long id);

    Sysrole getById(Long id);

    List<Sysrole> listAll();

    List<Sysrole> queryRolesDoNotRelateByUser(Long userId);

    List<Sysrole> listBlock();

    boolean nameExists(Sysrole sysrole);
}
