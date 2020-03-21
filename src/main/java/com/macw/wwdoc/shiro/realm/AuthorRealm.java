package com.macw.wwdoc.shiro.realm;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class AuthorRealm extends AuthorizingRealm {


   @Resource
   private IUserService iUserService;
   
    /**
     * 用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //根据认证信息获取用户名
       // String username = principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }


    /**
     * 用户验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //根据token获取用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        //查询数据库，
        User user = iUserService.getOne(new QueryWrapper<User>().lambda()
        		.eq(User::getUserName, username)
        		.eq(User::getPassword, password)
        		.eq(User::getState, Constant.ENABLE)
        		);
        //封装info
        if (user!=null) {
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), this.getName());
            return info;
        }else {
            return null;
        }
    }
}
