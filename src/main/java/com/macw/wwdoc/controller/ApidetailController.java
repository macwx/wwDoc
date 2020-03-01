package com.macw.wwdoc.controller;


import com.macw.wwdoc.entity.vo.TreeSelectVo;
import com.macw.wwdoc.mapper.CategoryMapper;
import com.macw.wwdoc.service.IApidetailService;
import com.macw.wwdoc.service.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 文章详情表 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@RestController
@RequestMapping("/apidetail")
public class ApidetailController extends BaseControler{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IApidetailService iApidetailService;

    @Resource
    private ICategoryService iCategoryService;

    @Resource
    private CategoryMapper categoryMapper;

    @RequestMapping("/toApiAdd")
    public ModelAndView toApiAdd(){
        ModelAndView mv = new ModelAndView(thyme + "/docs/apis/apiAdd");
        return mv;
    }

    @RequestMapping("/getTreeSelectVos")
    public List<TreeSelectVo> getTreeSelectVos(){
        List<TreeSelectVo> treeSelectVos = categoryMapper.listTreeSelectVo(getProId());
        return treeSelectVos;
    }
}
