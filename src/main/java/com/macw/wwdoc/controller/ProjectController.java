package com.macw.wwdoc.controller;


import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.Project;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.IProjectService;
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
 * 项目管理表 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@RestController
@RequestMapping("/project")
public class ProjectController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IProjectService iProjectService;

    @RequestMapping("/listProject")
    public ModelAndView listProject(){
        ModelAndView mv = new ModelAndView(thyme+"/project/projectList");
        List<Project> projectList = iProjectService.list();
        mv.addObject("projectList",projectList);
        return mv;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        return new ModelAndView(thyme+"/project/addProject");
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(Integer proId){
        logger.debug("----------------------------- "+proId);
        ModelAndView mv = new ModelAndView(thyme + "/project/projectSetting");
        Project project = iProjectService.getById(proId);
        mv.addObject("project",project);
        return mv;
    }


    @RequestMapping("/addOrUpdate")
    public ResultUtil addOrUpdate(Project project){
        User user = getUser();
        if (IntegerUtils.isBlank(project.getProId())){
            project.setCreateId(user.getUserId());
            project.setCreateUser(user.getUserName());
            project.setCreateTime(LocalDateTime.now());
        }else {
            project.setUpdateId(user.getUserId());
            project.setUpdateTime(LocalDateTime.now());
            project.setUpdateUser(user.getUserName());
        }
        boolean save = iProjectService.saveOrUpdate(project);
        if (save){
            return ResultUtil.success(Constant.SCUUESS_MSG);
        }else {
            return ResultUtil.error(Constant.ERROR_MSG);
        }
    }

    @RequestMapping("/deleteOne")
    public ResultUtil deleteOne(Integer proId){
        return ResultUtil.flag( iProjectService.removeById(proId));
    }


    @RequestMapping("/toDocs")
    public ModelAndView toDocs(Integer proId){
        logger.debug("----------------------------- "+proId);
        if (IntegerUtils.isNotBlank(proId)){
            getSession().setAttribute(Constant.PRO_ID,proId);
        }
        ModelAndView mv = new ModelAndView(thyme + "/docs");
        Project project = iProjectService.getById(proId);
        mv.addObject("project",project);
        User user = getUser();
        mv.addObject("user",user);
        return mv;
    }


}
