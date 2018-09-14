package br.eti.nogsantos.model.dao;

import br.eti.nogsantos.model.entity.Empresa;

import java.util.List;

public interface EmpresaDao {
    @SuppressWarnings("unchecked")
    List<Empresa> listagem();
}
