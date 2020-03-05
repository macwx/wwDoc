package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.Apidetail;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.entity.vo.TreeSelectVo;
import com.macw.wwdoc.mapper.CategoryMapper;
import com.macw.wwdoc.service.IApidetailService;
import com.macw.wwdoc.service.ICategoryService;
import com.macw.wwdoc.util.IntegerUtils;
import com.macw.wwdoc.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
public class ApidetailController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IApidetailService iApidetailService;

    @Resource
    private ICategoryService iCategoryService;

    @Resource
    private CategoryMapper categoryMapper;

    @RequestMapping("/toApiAdd")
    public ModelAndView toApiAdd() {
        ModelAndView mv = new ModelAndView(thyme + "/docs/apis/apiAdd");
        return mv;
    }

    /**
     * 添加api
     * 如果，相同分类id，创建人id，项目id，api Title，则认定为同一API，则更新版本
     * @param apidetail
     * @return
     */
    @RequestMapping("/addApi")
    public ResultUtil addApi(Apidetail apidetail) {
        User user = getUser();
        apidetail.setProjectId(getProId());
        apidetail.setCreateId(user.getUserId());
        apidetail.setCreateUser(user.getUserName());
        apidetail.setCreateTime(LocalDateTime.now());
        apidetail.setIsNew(1);
        Apidetail serviceOne = iApidetailService.getOne(new QueryWrapper<Apidetail>().lambda()
                .eq(Apidetail::getCreateId, user.getUserId())
                .eq(Apidetail::getTitle, apidetail.getTitle())
                .eq(Apidetail::getCategoryId, apidetail.getCategoryId())
                .eq(Apidetail::getProjectId, apidetail.getProjectId())
                .eq(Apidetail::getIsNew, 1));
        if (serviceOne!=null)  {
           serviceOne.setIsNew(0);
           apidetail.setVersion(serviceOne.getVersion()+1);
           iApidetailService.updateById(serviceOne);
        }
        return ResultUtil.flag(iApidetailService.save(apidetail));
    }

    /**
     * 查看历史版本
     * @param page
     * @param limit
     * @param apidetail
     * @return
     */
    @RequestMapping("/showVersion")
    public ResultUtil showVersion(int page, int limit,Apidetail apidetail){
        if (IntegerUtils.isBlank(apidetail.getCategoryId()) || StringUtils.isBlank(apidetail.getTitle())){
            return ResultUtil.error("历史版本为空！");
        }
        User user = getUser();
        Page<Apidetail> apidetailPage = new Page<>(page, limit);
        IPage<Apidetail> apidetailPage1 = iApidetailService.page(apidetailPage, new QueryWrapper<Apidetail>().lambda()
                .eq(Apidetail::getCategoryId, apidetail.getCategoryId())
                .eq(Apidetail::getProjectId, getProId())
                .eq(Apidetail::getTitle, apidetail.getTitle())
                .eq(Apidetail::getCreateId, user.getUserId())
                .select(Apidetail::getCreateTime, Apidetail::getCreateUser, Apidetail::getVersion));
        ResultUtil<Object> success = ResultUtil.success(Constant.SELECT_SUCCESS);
        success.setCount(apidetailPage1.getTotal());
        success.setData(apidetailPage1.getRecords());
        return success;

    }

    /**
     * 查询分类列表树
     * @return
     */
    @RequestMapping("/getTreeSelectVos")
    public List<TreeSelectVo> getTreeSelectVos() {
        List<TreeSelectVo> treeSelectVos = categoryMapper.listTreeSelectVo(getProId());
        return treeSelectVos;
    }

    @RequestMapping("/toAPIList")
    public ModelAndView toAPIList(){
        ModelAndView mv = new ModelAndView(thyme + "/docs/apis/apiList");
        return mv;
    }


    @RequestMapping("/listApi")
    public ResultUtil listApi(int page, int limit,Integer categoryId,String title){
        Page<Apidetail> apidetailPage = new Page<>(page, limit);
        Page<Apidetail> page1 = iApidetailService.page(apidetailPage, new QueryWrapper<Apidetail>().lambda()
                .eq(Apidetail::getProjectId, getProId())
        .eq(Apidetail::getIsNew, 1)
        .eq(IntegerUtils.isNotBlank(categoryId), Apidetail::getCategoryId, categoryId)
        .like(StringUtils.isNotBlank(title), Apidetail::getTitle, title));
        ResultUtil<Object> success = ResultUtil.success(Constant.SELECT_SUCCESS);
        success.setCount(page1.getTotal());
        success.setData(page1.getRecords());
        return success;
    }

}
