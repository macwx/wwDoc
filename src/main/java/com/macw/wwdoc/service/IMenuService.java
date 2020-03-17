package com.macw.wwdoc.service;

import com.macw.wwdoc.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macw.wwdoc.entity.vo.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 首页菜单
     * @param identify
     * @param title
     * @param icon
     * @return
     */
    MenuVo listMenuVo(Integer identify,String title,String icon);

}
