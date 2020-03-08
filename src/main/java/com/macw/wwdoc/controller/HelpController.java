package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.Help;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.IHelpService;
import com.macw.wwdoc.util.DateUtil;
import com.macw.wwdoc.util.IntegerUtils;
import com.macw.wwdoc.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.macw.wwdoc.controller.BaseController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-03-07
 */
@RestController
@RequestMapping("/help")
public class HelpController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IHelpService iHelpService;

    @RequestMapping("/toHelp")
    public ModelAndView toHelp(){
        return new ModelAndView(thyme+"/help/helpList");
    }

    @RequestMapping("/toHelpEdit")
    public ModelAndView toHelpEdit(Integer helpId){
        ModelAndView mv = new ModelAndView(thyme + "/help/helpEdit");
        if (IntegerUtils.isNotBlank(helpId)){
            Help help = iHelpService.getById(helpId);
            mv.addObject("help", help);
        }
        return mv;
    }

    @RequestMapping("/helpEdit")
    public ResultUtil helpEdit(Help help){
        logger.debug("------"+help);
        User user = getUser();
        if (IntegerUtils.isBlank(help.getHelpId())) {
            help.setCreateTime(LocalDateTime.now());
            help.setCreateName(user.getNickname());
            help.setCreateId(user.getUserId());
            return ResultUtil.flag(iHelpService.save(help));
        }else {
            help.setUpdateTime(LocalDateTime.now());
            return ResultUtil.flag(iHelpService.updateById(help));
        }
    }

    @RequestMapping("/listHelp")
    public ResultUtil listHelp(int page,int limit,String title){
        Page<Help> helpPage = new Page<>(page, limit);
        Page<Help> page1 = iHelpService.page(helpPage, new QueryWrapper<Help>().lambda()
                .like(StringUtils.isNotBlank(title), Help::getTitle, title)
        .orderByDesc(Help::getCreateTime));
        ResultUtil<Object> success = ResultUtil.success(Constant.SELECT_SUCCESS);
        success.setCount(page1.getTotal());
        success.setData(page1.getRecords());
        return success;
    }

    @RequestMapping("/deleteOne")
    public ResultUtil deleteOne(Integer helpId){
        return ResultUtil.flag(iHelpService.removeById(helpId));
    }

    @RequestMapping("/toHelpInfo")
    public ModelAndView toHelpInfo(Integer helpId){
        ModelAndView mv = new ModelAndView(thyme + "/help/helpInfo");
        Help help = iHelpService.getById(helpId);
        if (StringUtils.isNotBlank(help.getCreateTime().toString())){
            help.setTime(DateUtil.dateFormat(help.getCreateTime(), DateUtil.dateTime));
        }
        mv.addObject("help",help);
        return mv;
    }
}
