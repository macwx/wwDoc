package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.Template;
import com.macw.wwdoc.mapper.TemplateMapper;
import com.macw.wwdoc.service.ITemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 自定模板表 服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, Template> implements ITemplateService {

}
