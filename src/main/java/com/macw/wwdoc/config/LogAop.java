package com.macw.wwdoc.config;

/**
 * @author 马超伟
 * @PROJECT_NAME: fzll
 * @Description:
 * @date 15:29
 * @Copyright: All rights Reserved, Designed By Huerdai  
 * Copyright:    Copyright(C) 2019-2020
 * Company       Huerdai Henan LTD.
 */

import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.Log;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.ILogService;
import com.macw.wwdoc.service.IUserService;
import com.macw.wwdoc.util.IpAddressUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/*** @Aspect 标记当前类为功能增强类 切面类 *
 *  @Configuration 标记当前类为配置类 这个注解包含了@Component的功能
 */
@Aspect
@Configuration
public class LogAop {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService iUserService;

    @Resource
    private ILogService iLogService;

    /**
     * JoinPoint 连接点 就是切入点 通过这个对象可以获取切入点的相关所有信息 例如：被切入的方法和注解
     *
     * @param joinPoint  切入点的设置 切注解 @annotation
     */
    @After("@annotation(com.macw.wwdoc.config.Log)")
    public void logAfter(JoinPoint joinPoint) {

        Log log = new Log();
        log.setLogDate(LocalDateTime.now());
        // 1.获取日志相关的信息  用户的id session  ip  时间  操作的描述  类型  ctrl+H
        /**
         * 获取用户id
         * 为什么不能装配session？因为服务器有多个session
         * 通过 ServletRequestAttributes 可以获取当前请求
         * 当前请求可以获取当前会话的session
         */
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();
        String sessionid = session.getId();

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute(Constant.LOGIN_USER);

        if (user!=null){
            log.setLogUserId(user.getUserId());
        }

        /**
         * 获取用户的ip
         * 通过工具类 ip
         */
        log.setLogIp(IpAddressUtil.getIp());

        /**
         * 操作的描述
         *
         * 执行的方法不同  描述是不一样的
         * login         管理员登录
         * 获取注解的值
         */
//        1.通过连接点获取方法签名 被切入方法的所有信息
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        2.获取被切入方法对象
        Method method = signature.getMethod();
//        3.获取方法上的注解
        com.macw.wwdoc.config.Log annotation = method.getAnnotation(com.macw.wwdoc.config.Log.class);
//        4.获取注解的值
        String value = annotation.value();
        log.setLogContent(value);
        // 获取注解的类型
        String type = annotation.type();
        if (type!=null){
            log.setLogType(type);
        }
//        2.将日志对象 添加到数据库
        System.out.println(log);
        logger.debug("Log===="+log);
        boolean save = iLogService.save(log);
        logger.debug("保存日志------"+save);
    }
}

