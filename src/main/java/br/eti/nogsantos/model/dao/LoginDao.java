package br.eti.nogsantos.model.dao;

import br.eti.nogsantos.model.entity.Sysuser;

import java.util.Set;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 23, 2014
 */
public interface LoginDao {

    Sysuser getSysuserByLogin(String login);

    Set<String> getRoleByLogin(String login);

    Set<String> getPermissionByRole(String login);
}
