package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.mapper.UserMapper;
import com.macw.wwdoc.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
