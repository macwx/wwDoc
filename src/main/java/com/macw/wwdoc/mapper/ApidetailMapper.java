package com.macw.wwdoc.mapper;

import com.macw.wwdoc.entity.Apidetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macw.wwdoc.entity.vo.MenuVo;

import java.util.List;

/**
 * <p>
 * 文章详情表 Mapper 接口
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
public interface ApidetailMapper extends BaseMapper<Apidetail> {

    /**
     * 查询没有分类的API
     * @param proId
     * @return
     */
    List<MenuVo> listMenuVo(Integer proId);

}
