package com.macw.wwdoc;


import com.macw.wwdoc.util.ResultUtil;

/**
 * 静态全局变量
 *
 * @author:hosedu
 */
public class Constant {


    /**
     * 全局启用标识  1
     */
    public static final Integer ENABLE = 1; //启用

    /**
     * 全局禁用标识   0
     */
    public static final Integer DISABLES = 0; //禁用

    public static final Integer DEL = 1; //禁用

    public static final Integer DELNOT = 0; //禁用


    public static final String LOGIN_USER = "LOGIN_USER";
    public static final String LOGIN_FAIL = "未找到登陆用户信息";

    public static final String PASSWORD_FAIL = "密码与原密码不匹配";

    public static final String PHONE_IS_USE = "该手机号已被使用";
    public static final String PHONE_NOT_USE = "恭喜,该手机号可以注册";
    public static final String PHONE_MSM_CHECK_FAIL = "手机短信验证失败";

    public static final String LOGIN_OUT = "退出成功";
    public static final String LOGIN_SUCCESS_MSG = "登录成功";
    public static final String LOGIN_FAIL_MSG = "登录失败";

    public static final String ACCOUNT_NOT_FAIL = "未找到登录账号";

    public static final String PASSWORD_ERROR = "密码错误";

    public static final String ACCOUN_TMISMATCH = "账号密码不匹配";


    public static final String NOT_FIND_UPLOAD_IMG = "未找到上传图片";

    public static final String NOT_FIND_PARAM = "参数为空";

    public static final String SYSTEM_EXCEPTION = "系统异常";

    public static final String MSM_SEND_SUCCESS = "发送成功";
    public static final String MSM_SEND_FAIL = "发送失败";

    public static final String REGISTER_SUCCESS = "注册成功";
    public static final String REGISTER_FAIL = "注册失败";

    public static final String UPLOAD_FAIL = "上传失败";

    public static final String PARAM_FAIL = "请检查传入的参数是否正常";

    public static final String SELECT_FAIL = "查询失败";
    public static final String DELETE_FAIL = "删除失败";
    public static final String UPDATE_FAIL = "修改失败";
    public static final String INSERT_FAIL = "添加失败";

    public static final String SELECT_SUCCESS = "查询成功";
    public static final String DELETE_SUCCESS = "删除成功";
    public static final String UPDATE_SUCCESS = "修改成功";
    public static final String INSERT_SUCCESS = "添加成功";

    public static final Integer SCUUESS_CODE = 200;

    public static final String SCUUESS_MSG = "成功";

    public static final Integer ERROR_CODE = 400;

    public static final Integer LOG_CODE = 401;

    public static final String ERROR_MSG = "失败";


}
