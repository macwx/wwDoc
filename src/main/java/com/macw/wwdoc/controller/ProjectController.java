package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.config.Log;
import com.macw.wwdoc.entity.*;
import com.macw.wwdoc.service.IProjectService;
import com.macw.wwdoc.service.ITeamMemberService;
import com.macw.wwdoc.service.ITeamProService;
import com.macw.wwdoc.service.ITeamService;
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

    @Resource
    private ITeamProService iTeamProService;

    @Resource
    private ITeamMemberService iTeamMemberService;

    @Resource
    private ITeamService iTeamService;

    @RequestMapping("/listProject")
    public ModelAndView listProject() {
        ModelAndView mv = new ModelAndView(thyme + "/project/projectList");
        User user = getUser();
        List<TeamPro> teamProList = new ArrayList<>();
        List<TeamMember> teamMemberList = iTeamMemberService.list(new QueryWrapper<TeamMember>().lambda().eq(TeamMember::getUserId, user.getUserId()));
        for (TeamMember teamMember : teamMemberList) {
            List<Team> teamList = iTeamService.list(new QueryWrapper<Team>().lambda().eq(Team::getTeamId, teamMember.getTeamId()));
            for (Team team : teamList) {
                teamProList = iTeamProService.list(new QueryWrapper<TeamPro>().lambda().eq(TeamPro::getTeamId, team.getTeamId()));
            }
        }

        List<Project> projectList = iProjectService.list(new QueryWrapper<Project>().lambda()
                .eq(Project::getCreateId, user.getUserId()).or()
                .eq(teamProList.size() > 0, Project::getProId, teamProList));
        mv.addObject("projectList", projectList);
        return mv;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd() {
        return new ModelAndView(thyme + "/project/addProject");
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(Integer proId) {

        ModelAndView mv = new ModelAndView(thyme + "/project/projectSetting");
        Project project = iProjectService.getById(proId);
        mv.addObject("project", project);
        return mv;
    }


    @Log(value = "添加/更新项目", type = "add")
    @RequestMapping("/addOrUpdate")
    public ResultUtil addOrUpdate(Project project) {
        User user = getUser();
        if (IntegerUtils.isBlank(project.getProId())) {
            project.setCreateId(user.getUserId());
            project.setCreateUser(user.getUserName());
            project.setCreateTime(LocalDateTime.now());
        } else {
            project.setUpdateId(user.getUserId());
            project.setUpdateTime(LocalDateTime.now());
            project.setUpdateUser(user.getUserName());
        }
        boolean save = iProjectService.saveOrUpdate(project);
        if (save) {
            return ResultUtil.success(Constant.SCUUESS_MSG);
        } else {
            return ResultUtil.error(Constant.ERROR_MSG);
        }
    }

    @Log(value = "删除项目", type = "del")
    @RequestMapping("/deleteOne")
    public ResultUtil deleteOne(Integer proId) {
        return ResultUtil.flag(iProjectService.removeById(proId));
    }


    @RequestMapping("/toDocs")
    public ModelAndView toDocs(Integer proId) {

        if (IntegerUtils.isNotBlank(proId)) {
            getSession().setAttribute(Constant.PRO_ID, proId);
        }
        ModelAndView mv = new ModelAndView(thyme + "/docs");
        Project project = iProjectService.getById(proId);
        mv.addObject("project", project);
        User user = getUser();
        mv.addObject("user", user);
        return mv;
    }


}
