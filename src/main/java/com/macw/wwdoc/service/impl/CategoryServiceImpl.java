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
import com.macw.wwdoc.util.IntegerUtils;
import org.apache.commons.lang3.StringUtils;
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
    public MenuVo listMenuVo(Integer userId,Integer proId, String title, String icon) {
        List<MenuVo> menuVos = this.listMenuVo(userId,proId);
        List<MenuVo> menuVoList = menuMapper.listMenuVo(2);
        List<MenuVo> listMenuVo = iApidetailService.listMenuVo(proId);
        menuVos.addAll(listMenuVo);
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

    @Override
    public List<MenuVo> listMenuVo(Integer userId, Integer proId) {
        List<MenuVo> menuVos = this.baseMapper.listMenuVo(userId, proId);
        for (MenuVo menuVo : menuVos) {
            menuVo.setHref("/menu/to404");
            List<MenuVo> child = menuVo.getChild();
            for (MenuVo vo : child) {
                vo.setHref("/menu/to404");
            }
        }
        return menuVos;
    }

    private List<MenuVo> childApi(Integer menuId) {
        List<Apidetail> list = iApidetailService.list(new QueryWrapper<Apidetail>().lambda().eq(Apidetail::getCategoryId, menuId));
        List<MenuVo> menuVoChild = new ArrayList<>();
        if (list.size() > 0) {
            for (Apidetail apidetail : list) {
                MenuVo vo = new MenuVo();
                if (IntegerUtils.isNotBlank(apidetail.getApidetailId())){
                    vo.setHref("/apidetail/apiView?apiId="+apidetail.getApidetailId());
                }else {
                    vo.setHref("/menu/to404");
                }
                vo.setTitle(apidetail.getTitle());
                vo.setTarget("_self");
                vo.setIcon("fa fa-file-text-o");
                menuVoChild.add(vo);
            }
        }
        return menuVoChild;
    }


}
