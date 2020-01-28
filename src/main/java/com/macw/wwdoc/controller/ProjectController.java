package com.macw.wwdoc.controller;


import com.macw.wwdoc.entity.Project;
import com.macw.wwdoc.service.IProjectService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
public class ProjectController {

    @Resource
    private IProjectService iProjectService;

    @RequestMapping("/listProject")
    public ModelAndView listProject(){
        ModelAndView mv = new ModelAndView("views/project/project");
        List<Project> projectList = iProjectService.list();
        mv.addObject("projectList",projectList);
        return mv;

    }

}
