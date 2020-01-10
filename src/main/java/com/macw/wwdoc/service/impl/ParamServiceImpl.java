package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.Param;
import com.macw.wwdoc.mapper.ParamMapper;
import com.macw.wwdoc.service.IParamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 请求参数表 服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-01-10
 */
@Service
public class ParamServiceImpl extends ServiceImpl<ParamMapper, Param> implements IParamService {

}
