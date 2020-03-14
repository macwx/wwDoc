package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.config.Log;
import com.macw.wwdoc.entity.Apidetail;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.entity.vo.TreeSelectVo;
import com.macw.wwdoc.mapper.CategoryMapper;
import com.macw.wwdoc.service.IApidetailService;
import com.macw.wwdoc.service.ICategoryService;
import com.macw.wwdoc.util.DateUtil;
import com.macw.wwdoc.util.FileUploadUtil;
import com.macw.wwdoc.util.IntegerUtils;
import com.macw.wwdoc.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 添加APi 或者查询单个APi
     *
     * @param apiId
     * @return
     */

    @RequestMapping("/toApiAdd")
    public ModelAndView toApiAdd(Integer apiId) {
        ModelAndView mv = new ModelAndView(thyme + "/docs/apis/apiAdd");
        if (IntegerUtils.isNotBlank(apiId)) {
            Apidetail apidetail = iApidetailService.getById(apiId);
            mv.addObject("apidetail", apidetail);
        }
        return mv;
    }

    /**
     * 添加api
     * 如果，相同分类id，创建人id，项目id，api Title，则认定为同一API，则更新版本
     *
     * @param apidetail
     * @return
     */
    @Log(value = "添加API", type = "add")
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
        if (serviceOne != null) {
            serviceOne.setIsNew(0);
            apidetail.setVersion(serviceOne.getVersion() + 1);
            iApidetailService.updateById(serviceOne);
        }
        return ResultUtil.flag(iApidetailService.save(apidetail));
    }

    /**
     * 查看历史版本
     *
     * @param page
     * @param limit
     * @param apidetail
     * @return
     */
    @RequestMapping("/showVersion")
    public ResultUtil showVersion(int page, int limit, Apidetail apidetail) {
        if (IntegerUtils.isBlank(apidetail.getCategoryId()) || StringUtils.isBlank(apidetail.getTitle())) {
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
     *
     * @return
     */
    @RequestMapping("/getTreeSelectVos")
    public List<TreeSelectVo> getTreeSelectVos(Integer  id) {
        List<TreeSelectVo> treeSelectVos = categoryMapper.listTreeSelectVo(getProId());
        for (TreeSelectVo treeSelectVo : treeSelectVos) {
            treeSelectVo.setOpen(true);
            treeSelectVo.setChecked(false);

            if (treeSelectVo.getId().equals(id)) {
                treeSelectVo.setChecked(true);
            }
            List<TreeSelectVo> children = treeSelectVo.getChildren();
            for (TreeSelectVo child : children) {
                child.setChecked(false);
                child.setOpen(true);
                if (child.getId().equals(id)) {
                    child.setChecked(true);
                }
            }
        }

        return treeSelectVos;
    }

    @RequestMapping("/toAPIList")
    public ModelAndView toAPIList() {
        ModelAndView mv = new ModelAndView(thyme + "/docs/apis/apiList");
        return mv;
    }

    /**
     * 查询API列表
     *
     * @param page
     * @param limit
     * @param categoryId
     * @param title
     * @return
     */
    @RequestMapping("/listApi")
    public ResultUtil listApi(int page, int limit, Integer categoryId, String title) {
        Page<Apidetail> apidetailPage = new Page<>(page, limit);
        Page<Apidetail> page1 = iApidetailService.page(apidetailPage, new QueryWrapper<Apidetail>().lambda()
                .eq(Apidetail::getProjectId, getProId())
                .eq(Apidetail::getIsNew, 1)
                .eq(IntegerUtils.isNotBlank(categoryId), Apidetail::getCategoryId, categoryId)
                .like(StringUtils.isNotBlank(title), Apidetail::getTitle, title)
                .orderByDesc(Apidetail::getCreateTime));
        ResultUtil<Object> success = ResultUtil.success(Constant.SELECT_SUCCESS);
        success.setCount(page1.getTotal());
        success.setData(page1.getRecords());
        return success;
    }

    /**
     * 删除单个API
     *
     * @param apiId
     * @return
     */
    @Log(value = "删除API", type = "del")
    @RequestMapping("/deleteOne")
    public ResultUtil deleteOne(Integer apiId) {
        return ResultUtil.flag(iApidetailService.removeById(apiId));
    }

    @Log(value = "导出word",type = "export")
    @RequestMapping("/export")
    public void export(Integer apiId,HttpServletRequest request, HttpServletResponse response){
        Apidetail apidetail = iApidetailService.getById(apiId);
        Map<String,Object> params = new HashMap<>(16);
        params.put("title",apidetail.getTitle());
        params.put("author",apidetail.getCreateUser());
        params.put("time", DateUtil.dateFormat(apidetail.getCreateTime(),DateUtil.dateTime));
        params.put("context", apidetail.getContext());
        FileUploadUtil.exportWord("http://wwdoc.henaumcw.top/2020/03/14/13/41/16/a6e67290", System.getProperty("user.dir")+"/temp",apidetail.getTitle()+".docx",params,request,response);
    }
}
