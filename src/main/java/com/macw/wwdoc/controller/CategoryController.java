package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macw.wwdoc.entity.Category;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.ICategoryService;
import com.macw.wwdoc.util.IntegerUtils;
import com.macw.wwdoc.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 文章分类表 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ICategoryService iCategoryService;

    @RequestMapping("toCategoryList")
    public ModelAndView toCategory() {
        logger.debug("proid========" + getProId());
        return new ModelAndView(thyme + "/docs/category/categoryList");
    }

    @RequestMapping("/listCategory")
    public ResultUtil listCategory() {
        LambdaQueryWrapper<Category> qw = new QueryWrapper<Category>().lambda().eq(Category::getProjectId, getProId()).orderByDesc(Category::getSort);
        List<Category> categoryList = iCategoryService.list(qw);
        ResultUtil<List<Category>> resultUtil = ResultUtil.success(categoryList);
        resultUtil.setCount((long) categoryList.size());
        return resultUtil;
    }

    @RequestMapping("/toAddCategory")
    public ModelAndView toAddCategory(Integer categoryId, Integer editId) {
        ModelAndView mv = new ModelAndView(thyme + "/docs/category/categoryEdit");
        if (IntegerUtils.isNotBlank(categoryId)) {
            mv.addObject("categoryId", categoryId);
        }
        if (IntegerUtils.isNotBlank(editId)) {
            Category category = iCategoryService.getById(editId);
            mv.addObject("category", category);
        }
        return mv;
    }

    @RequestMapping("/addCategory")
    public ResultUtil addCategory(Category category, Integer parentIds, Integer cids) {
        User user = getUser();
        if (IntegerUtils.isBlank(cids)) {
            if (IntegerUtils.isBlank(parentIds)) {
                category.setParentId(0);
            } else {
                category.setParentId(parentIds);
            }
            category.setProjectId(getProId());
            category.setCreateId(user.getUserId());
            category.setCreateUser(user.getUserName());
            category.setCreateTime(LocalDateTime.now());
            return ResultUtil.flag(iCategoryService.save(category));
        } else {
            category.setUpdateId(user.getUserId());
            category.setUpdateUser(user.getUserName());
            category.setUpdateTime(LocalDateTime.now());
            return ResultUtil.flag(iCategoryService.updateById(category));
        }
    }

    @RequestMapping("/deleteCategory")
    public ResultUtil deleteCategory(Integer categoryId) {
        List<Integer> list = new ArrayList<>();
        ////先把要删除的一级分类id放入到集合中
        list.add(categoryId);
        //递归的将一级分类下的id也加入到集合中
        diGui(categoryId, list);
        //执行批量删除
        boolean b = iCategoryService.removeByIds(list);
        return ResultUtil.flag(b);
    }

    //递归方法
    private void diGui(Integer cid,List<Integer> ids) {
        List<Category> categoryList = iCategoryService.list(new QueryWrapper<Category>().lambda().eq(Category::getParentId, cid));
        if (categoryList != null && categoryList.size() > 0) {
            for (Category category : categoryList) {
                Integer id = category.getCategoryId();
                ids.add(id);
                this.diGui(id, ids);
            }
        }
    }



}
