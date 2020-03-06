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

import com.macw.wwdoc.service.IUserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*** @Aspect 标记当前类为功能增强类 切面类 *
 *  @Configuration 标记当前类为配置类 这个注解包含了@Component的功能
 */
@Aspect
@Configuration
public class LogAop {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService iUserService;


    /**
     * JoinPoint 连接点 就是切入点 通过这个对象可以获取切入点的相关所有信息 例如：被切入的方法和注解
     *
     * @param joinPoint ** 切入点的设置 切注解 @annotation *
     */
    @After("@annotation(com.tourism.hu.config.Log)")
    public void logAfter(JoinPoint joinPoint) {

      //  CustomerLoginLog loginLog = new CustomerLoginLog();
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
      /* // Object obj = redisTemplate.opsForValue().get(sessionid);
        String customerId = "";
        if(obj!=null) {
            customerId=obj.toString();
        }
        CustomerInfo customerInfo = iCustomerInfoService.getOne(new QueryWrapper<CustomerInfo>().eq("id", customerId));
        if (customerInfo!=null){
            loginLog.setCustomerId(customerInfo.getCustomerId());
            loginLog.setLoginTime(LocalDateTime.now());
        }

        *//**
         * 获取用户的ip
         * 通过工具类 ip
         *//*
        loginLog.setLoginIp(IpAddressUtil.getIp());


        *//**
         * 操作的描述
         *
         * 执行的方法不同  描述是不一样的
         * login         管理员登录
         * 获取注解的值
         *//*
//        1.通过连接点获取方法签名 被切入方法的所有信息
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        2.获取被切入方法对象
        Method method = signature.getMethod();
//        3.获取方法上的注解
        Log annotation = method.getAnnotation(Log.class);
//        4.获取注解的值
        String value = annotation.value();
        loginLog.setLogContent(value);
        // 获取注解的类型
        String type = annotation.type();
        if (type!=null){
            loginLog.setLoginType(type);
        }
//        2.将日志对象 添加到数据库
        System.out.println(loginLog);
        logger.debug("loginLog===="+loginLog);
        boolean save = iCustomerLoginLogService.save(loginLog);
        logger.debug("保存日志------"+save);*/
    }
}

