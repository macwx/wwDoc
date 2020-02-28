package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.Menu;
import com.macw.wwdoc.entity.vo.MenuVo;
import com.macw.wwdoc.mapper.MenuMapper;
import com.macw.wwdoc.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    private MenuMapper menuMapper;


    @Override
    public MenuVo listMenuVo(Integer identify,String title,String icon) {
        List<MenuVo> menuVos = menuMapper.listMenuVo(identify);
        for (MenuVo menuVo : menuVos) {
            if (menuVo.getChild()!=null) {
                for (MenuVo menuVoChild :menuVo.getChild()) {
                    menuVoChild.setTarget("_self");
                }
            }
            if (menuVo.getChild().size()==0){
                menuVo.setChild(null);
            }
            menuVo.setTarget("_self");
        }
        MenuVo menuVo = new MenuVo();
        menuVo.setTitle(title);
        menuVo.setIcon(icon);
        menuVo.setHref("http://www.baidu.com");
        menuVo.setTarget("_self");
        menuVo.setChild(menuVos);

        return menuVo;
    }
}
