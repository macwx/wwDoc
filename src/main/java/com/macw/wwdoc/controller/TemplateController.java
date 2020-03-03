package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.Template;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.ITemplateService;
import com.macw.wwdoc.util.IntegerUtils;
import com.macw.wwdoc.util.ResultUtil;
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
 * 自定模板表 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@RestController
@RequestMapping("/template")
public class TemplateController extends BaseControler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ITemplateService iTemplateService;

    /**
     * 创建模板
     * @param template
     * @return
     */
    @RequestMapping("/addTemplate")
    public ResultUtil addTemplate(Template template){
        User user = getUser();
        template.setCreateId(user.getUserId());
        template.setCreateUser(user.getUserName());
        template.setCreateTime(LocalDateTime.now());
        return ResultUtil.flag(iTemplateService.save(template));
    }

    /**
     * 根据模板id查询模板
     * @param temId
     * @return
     */
    @RequestMapping("/selectTemplate")
    public ResultUtil selectTemplate(Integer temId){
            return ResultUtil.success(iTemplateService.getById(temId));
    }

    @RequestMapping("/toTempList")
    public ModelAndView toTempList(){
        return new ModelAndView(thyme+"/docs/templates/templateList");
    }

    /**
     * 根据用户id查询模板
     * @return
     */
    @RequestMapping("/selectTemplateByUser")
    public ResultUtil selectTemplateByUser(int page, int limit){
        User user = getUser();
        Page<Template> page1 = new Page<>(page, limit);
        IPage<Template> page2 = iTemplateService.page(page1, new QueryWrapper<Template>().lambda().eq(Template::getCreateId, user.getUserId()));
        ResultUtil<Object> success = ResultUtil.success(Constant.SELECT_SUCCESS);
        success.setCount(page2.getTotal());
        success.setData(page2.getRecords());
        return success;
    }

    @RequestMapping("/deleteOne")
    public ResultUtil deleteOne(Integer tempId){
        return ResultUtil.flag(iTemplateService.removeById(tempId));
    }

}
