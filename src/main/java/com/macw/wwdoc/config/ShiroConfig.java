package com.macw.wwdoc.config;

import com.macw.wwdoc.realm.AuthorRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maCw
 * @version 1.0
 */
@Configuration
public class ShiroConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultSecurityManager defaultSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //过滤器链，过滤拦截规则，
        Map<String,String> map = new HashMap<>();
        /**
         * anon ,代表匿名可访问，
         * authc ,认证后才可访问
         */
    /*    map.put("/api/**", "anon");
        map.put("/user/login", "anon");
        map.put("/layuiadmin/**", "anon");
        map.put("/js/**", "anon");
        map.put("/ui/**", "anon");
        map.put("/logout", "logout");

        map.put("/**", "authc");*/
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultSecurityManager);

        shiroFilterFactoryBean.setLoginUrl("/views/login.jsp");
        return shiroFilterFactoryBean;

    }

    /**
     * 创建安全管理器
     * @return
     */
    @Bean
    public DefaultSecurityManager getDefaultSecurityManager(AuthorRealm authorRealm) {
        DefaultSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        logger.info("--defaultSecurityManager" + defaultSecurityManager);
        //需要赋值一个Realm
        defaultSecurityManager.setRealm(authorRealm);
        return defaultSecurityManager;
    }

/*    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(259200000);
        cookieRememberMeManager.setCookie(simpleCookie);
        cookieRememberMeManager.setCipherKey(Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA=="));
        return cookieRememberMeManager;
    }*/

    /**
     * 创建自定义的MyRealm
     * @return
     */
    @Bean
    public AuthorRealm getAuthorRealm() {
        AuthorRealm authorRealm = new AuthorRealm();
        return authorRealm;
    }



    /**
     * 开启shiro aop注解支持
     * 使用代理方式;所以需要开启代码支持;否则@RequiresRoles等注解无法生效
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
