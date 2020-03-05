package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.Config;
import com.macw.wwdoc.mapper.ConfigMapper;
import com.macw.wwdoc.service.IConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-03-04
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

}
