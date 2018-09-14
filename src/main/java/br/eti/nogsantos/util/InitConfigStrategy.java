
package br.eti.nogsantos.util;

import br.com.caelum.vraptor.security.strategy.ShiroInitConfigStrategy;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 24, 2014
 */
public class InitConfigStrategy implements ShiroInitConfigStrategy {
    @Override
    public void init(DefaultWebSecurityManager securityManager, AuthorizingRealm realm) {
        /*
         * Defines login using encripted password
         */
        realm.setCredentialsMatcher(new PasswordMatcher());
        /*
         *  Defines
         */
//        ((DefaultWebSessionManager)securityManager.getSessionManager()).setSessionDAO();
        /*
         * Desativando o gerenciamento de sessão para que o Apache Shiro
         * não crie sessões de usuário automaticamente.
         */
//        DefaultWebSessionStorageEvaluator evaluator = new DefaultWebSessionStorageEvaluator();
//        evaluator.setSessionStorageEnabled(false);
//        ((DefaultSubjectDAO)securityManager.getSubjectDAO()).setSessionStorageEvaluator(evaluator);
        /*
         * Tempo de vida da sessão
         */
        //3.600.000 milesegundos = 1 hora
        ((DefaultSessionManager) securityManager.getSessionManager()).setGlobalSessionTimeout(3600000);
    }
}