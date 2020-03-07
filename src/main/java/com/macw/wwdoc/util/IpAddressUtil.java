package com.macw.wwdoc.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author 马超伟
 * @ClassName: IpAddressUtil
 * @Description: 获取IP地址
 * @date 2019年10月13日 下午10:42:21
 */
public class IpAddressUtil {

    private static Logger logger = LoggerFactory.getLogger(IpAddressUtil.class);

    /**
     * 获取当前访问用户的ip地址
     *
     * @return
     */
    public static String getIp() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = "null";
        try {
            ip = request.getHeader("x-forwarded-for");
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } catch (Exception e) {
            logger.error("IPUtils ERROR ", e);
        }
        //使用代理，则获取第一个IP地址
        if(StringUtils.isNotEmpty(ip) && ip.length() > 15) {
          if(ip.indexOf(",") > 0) {
              ip = ip.substring(0, ip.indexOf(","));
          }
      }
        return ip;
    }

}
