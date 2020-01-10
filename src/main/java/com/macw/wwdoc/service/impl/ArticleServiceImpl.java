package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.Article;
import com.macw.wwdoc.mapper.ArticleMapper;
import com.macw.wwdoc.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章详情表 服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-01-10
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
