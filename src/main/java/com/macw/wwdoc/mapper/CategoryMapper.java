package com.macw.wwdoc.mapper;

import com.macw.wwdoc.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macw.wwdoc.entity.vo.MenuVo;
import com.macw.wwdoc.entity.vo.TreeSelectVo;

import java.util.List;

/**
 * <p>
 * 文章分类表 Mapper 接口
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 树形下拉框查询
     * @param proId
     * @return
     */
    List<TreeSelectVo> listTreeSelectVo(Integer proId);

    /**
     * doc 分类菜单
     * @param userId
     * @return
     */
    List<MenuVo> listMenuVo(Integer userId,Integer proId);

}
