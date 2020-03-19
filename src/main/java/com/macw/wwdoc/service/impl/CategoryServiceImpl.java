package com.macw.wwdoc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macw.wwdoc.entity.Apidetail;
import com.macw.wwdoc.entity.Category;
import com.macw.wwdoc.entity.vo.MenuVo;
import com.macw.wwdoc.mapper.CategoryMapper;
import com.macw.wwdoc.mapper.MenuMapper;
import com.macw.wwdoc.service.IApidetailService;
import com.macw.wwdoc.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 文章分类表 服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private IApidetailService iApidetailService;

    @Override
    public MenuVo listMenuVo(Integer userId, String title, String icon) {
        List<MenuVo> menuVos = categoryMapper.listMenuVo(userId);
        List<MenuVo> menuVoList = menuMapper.listMenuVo(2);
        menuVos.addAll(menuVoList);
        for (MenuVo menuVo : menuVos) {
            List<MenuVo> childApi = childApi(menuVo.getMenuId());
            if (menuVo.getChild() != null) {
                List<MenuVo> child = menuVo.getChild();
                if (childApi.size() > 0) {
                    child.addAll(childApi);
                }
                for (MenuVo menuVoChild : menuVo.getChild()) {
                    menuVoChild.setTarget("_self");
                    List<MenuVo> voList = childApi(menuVoChild.getMenuId());
                    List<MenuVo> voChildChild = menuVoChild.getChild();
                    if (voChildChild != null) {
                        if (voList.size() > 0) {
                            voChildChild.addAll(voList);
                        }
                    }
                }
            }
            if (menuVo.getChild().size() == 0) {
                menuVo.setChild(null);
            }
            menuVo.setTarget("_self");
        }
        MenuVo menuVo = new MenuVo();
        menuVo.setTitle(title);
        menuVo.setIcon(icon);
        menuVo.setTarget("_self");
        menuVo.setChild(menuVos);

        return menuVo;
    }

    private List<MenuVo> childApi(Integer menuId) {
        List<Apidetail> list = iApidetailService.list(new QueryWrapper<Apidetail>().lambda().eq(Apidetail::getCategoryId, menuId));
        List<MenuVo> menuVoChild = new ArrayList<>();
        if (list.size() > 0) {
            for (Apidetail apidetail : list) {
                MenuVo vo = new MenuVo();
                vo.setHref("/apidetail/apiView?apiId="+apidetail.getApidetailId());
                vo.setTitle(apidetail.getTitle());
                vo.setTarget("_self");
                vo.setIcon("fa fa-file-text-o");
                menuVoChild.add(vo);
            }
        }
        return menuVoChild;
    }


}
