package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.Log;
import com.macw.wwdoc.mapper.LogMapper;
import com.macw.wwdoc.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-03-06
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
