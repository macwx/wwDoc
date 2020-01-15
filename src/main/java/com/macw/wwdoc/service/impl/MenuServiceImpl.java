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
    public Map listMenuVo(Integer identify) {
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
        Map<String,Object> map = new HashMap<>();
        MenuVo menuVo = new MenuVo();
        menuVo.setTitle("控制台");
        menuVo.setIcon("fa fa-home");
        menuVo.setChild(menuVos);
        map.put("control", menuVo);
        return map;
    }
}
