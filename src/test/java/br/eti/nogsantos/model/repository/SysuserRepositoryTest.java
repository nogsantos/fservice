/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eti.nogsantos.model.repository;

import br.com.caelum.vraptor.util.test.MockResult;
import br.eti.nogsantos.model.dao.SysuserDao;
import br.eti.nogsantos.model.entity.Sysuser;
import org.apache.shiro.authc.credential.PasswordService;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author nogsantos
 */
@RunWith(MockitoJUnitRunner.class)
public class SysuserRepositoryTest {

    @Mock
    private SysuserDao dao;
    @Mock
    private MockResult result;
    @Mock
    private PasswordService passwordService;
    @Mock
    protected Session session;
    @Mock
    protected SystemRepository repository;
    @InjectMocks
    private SysuserRepository instance ;

    @Test
    public void testInsert() {
        Sysuser sysuser = new Sysuser();
        for (int i = 0; i < 1000; i++) {
            sysuser.setName("Test mock" + i);
//            instance.insert(any(), any());
        }
    }

    @Test
    public void verificaSeLoginExiste() {
        Sysuser sysuser = new Sysuser();
        sysuser.setLogin("admin");
    }

}
