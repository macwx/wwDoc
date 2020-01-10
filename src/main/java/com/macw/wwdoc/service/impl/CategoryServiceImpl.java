package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.Category;
import com.macw.wwdoc.mapper.CategoryMapper;
import com.macw.wwdoc.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章分类表 服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-01-10
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
