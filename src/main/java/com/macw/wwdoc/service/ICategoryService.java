package com.macw.wwdoc.service;

import com.macw.wwdoc.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macw.wwdoc.entity.vo.MenuVo;

import java.util.List;

/**
 * <p>
 * 文章分类表 服务类
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
public interface ICategoryService extends IService<Category> {

    /**
     * Api 分类菜单
     * @param title
     * @param icon
     * @return
     */
    MenuVo listMenuVo(Integer userId,String title,String icon);

}
