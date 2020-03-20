package com.macw.wwdoc.shiro.properties;

import lombok.Data;

/**
 * @author Macw
 */
@Data
public class ShiroProperties {

    private long sessionTimeout;
    private int cookieTimeout;
    private String anonUrl;
    private String loginUrl;
    private String successUrl;
    private String logoutUrl;
    private String unauthorizedUrl;
}

