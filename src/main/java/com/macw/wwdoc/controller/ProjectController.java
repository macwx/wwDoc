package com.macw.wwdoc.controller;


import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.Project;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.IProjectService;
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
 * 项目管理表 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@RestController
@RequestMapping("/project")
public class ProjectController extends BaseControler{

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

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(){
        return new ModelAndView(thyme+"/project/projectEdit");
    }

    @RequestMapping("/addOrUpdate")
    public ResultUtil addOrUpdate(Project project){
        logger.debug("///////... "+project);
        User user = getUser();

        boolean save = iProjectService.save(project);
        if (IntegerUtils.isBlank(project.getProId())){
            project.setCreateId(user.getUserId());
            project.setCreateUser(user.getUserName());
            project.setCreateTime(LocalDateTime.now());
        }else {
            project.setUpdateId(user.getUserId());
            project.setUpdateTime(LocalDateTime.now());
            project.setUpdateUser(user.getUserName());
        }
        if (save){
            return ResultUtil.success(Constant.SCUUESS_MSG);
        }else {
            return ResultUtil.error(Constant.ERROR_MSG);
        }
    }

}
