package com.macw.wwdoc.mapper;

import com.macw.wwdoc.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macw.wwdoc.entity.vo.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<MenuVo> listMenuVo(@Param("identify") Integer identify);

}
