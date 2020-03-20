package com.macw.wwdoc.shiro.config;

import com.macw.wwdoc.shiro.properties.FebsProperties;
import com.macw.wwdoc.shiro.realm.AuthorRealm;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * @author maCw
 * @version 1.0
 */
@Configuration
public class ShiroConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FebsProperties febsProperties;

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置 securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 登录的 url
        shiroFilterFactoryBean.setLoginUrl(febsProperties.getShiro().getLoginUrl());
        // 登录成功后跳转的 url
        shiroFilterFactoryBean.setSuccessUrl(febsProperties.getShiro().getSuccessUrl());
        // 未授权 url
        shiroFilterFactoryBean.setUnauthorizedUrl(febsProperties.getShiro().getUnauthorizedUrl());

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 设置免认证 url
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(febsProperties.getShiro().getAnonUrl(), ",");
        for (String url : anonUrls) {
            filterChainDefinitionMap.put(url, "anon");
        }
        // 配置退出过滤器，其中具体的退出代码 Shiro已经替我们实现了
        filterChainDefinitionMap.put(febsProperties.getShiro().getLogoutUrl(), "logout");

        // 除上以外所有 url都必须认证通过才可以访问，未通过认证自动访问 LoginUrl
        filterChainDefinitionMap.put("/**", "user");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }



   /* @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultSecurityManager defaultSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //过滤器链，过滤拦截规则，
        Map<String,String> map = new HashMap<>(16);
        *//**
         * anon ,代表匿名可访问，
         * authc ,认证后才可访问
         *//*
        map.put("/user/**", "anon");
        map.put("/layuimini/**", "anon");
        map.put("/js/**", "anon");
        map.put("/css/**", "anon");
        map.put("/img/**", "anon");
        map.put("/FileUpload/**", "anon");
        map.put("/index/**", "anon");
        map.put("/", "anon");
        map.put("/logout", "logout");
        map.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultSecurityManager);
        shiroFilterFactoryBean.setLoginUrl("/user/toLogin");
        return shiroFilterFactoryBean;
    }*/

    /**
     * 创建安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(AuthorRealm authorRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 配置 SecurityManager，并注入 shiroRealm
        securityManager.setRealm(authorRealm);
      /*  // 配置 缓存管理类 cacheManager
        securityManager.setCacheManager(cacheManager());*/
        // 配置 rememberMeCookie
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /**
     * rememberMe cookie 效果是重开浏览器后无需重新登录
     *
     * @return SimpleCookie
     */
    private SimpleCookie rememberMeCookie() {
        // 设置 cookie 名称，对应 login.html 页面的 <input type="checkbox" name="rememberMe"/>
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        // 设置 cookie 的过期时间，单位为秒，这里为一天
        cookie.setMaxAge(5000);
        return cookie;
    }

    /**
     * cookie管理对象
     *
     * @return CookieRememberMeManager
     */
    private CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie 加密的密钥
        String encryptKey = "shiro_key";
        byte[] encryptKeyBytes = encryptKey.getBytes(StandardCharsets.UTF_8);
        String rememberKey = Base64Utils.encodeToString(Arrays.copyOf(encryptKeyBytes, 16));
        cookieRememberMeManager.setCipherKey(Base64.decode(rememberKey));
        return cookieRememberMeManager;
    }


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
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
