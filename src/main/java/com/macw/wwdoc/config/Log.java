package com.macw.wwdoc.config;

/**
 * @author 马超伟
 * @PROJECT_NAME: wwDoc
 * @Description:
 * @date 15:26
 * @Copyright: All rights Reserved, Designed By Huerdai  
 * Copyright:    Copyright(C) 2019-2020
 * Company       Huerdai Henan LTD.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*** 元注解：加在自定义注解上的注解
 *  @author Administrator
 * @Target 定义注解可以添加的位置 METHOD 方法上 type 类上
 * @Retention RUNTIME 运行时 不管编译 还是 运行 这个注解都可以用
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    /**
     * 写法类似于接口的方法 后面可以通过default 关键字给默认值
     * 用法类似于属性
     * @return
     */
    String value() default "";
    String type() default "";
}
