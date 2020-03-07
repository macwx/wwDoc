package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.config.Log;
import com.macw.wwdoc.entity.Project;
import com.macw.wwdoc.entity.TeamPro;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.IProjectService;
import com.macw.wwdoc.service.ITeamMemberService;
import com.macw.wwdoc.service.ITeamProService;
import com.macw.wwdoc.service.ITeamService;
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
 * 团队项目表 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@RestController
@RequestMapping("/teamPro")
public class TeamProController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ITeamService iTeamService;

    @Resource
    private ITeamMemberService iTeamMemberService;

    @Resource
    private ITeamProService iTeamProService;

    @Resource
    private IProjectService iProjectService;

    @RequestMapping("/toTeamPro")
    public ModelAndView toTeamPro(Integer teamId){
        ModelAndView mv = new ModelAndView(thyme + "/team/teamProList");
        mv.addObject("teamId",teamId);
        return mv;
    }

    @RequestMapping("/listTeamPro")
    public ResultUtil listTeamPro(int page,int limit,Integer teamId){
        Page<TeamPro> teamProPage = new Page<>(page, limit);
        Page<TeamPro> proPage = iTeamProService.page(teamProPage, new QueryWrapper<TeamPro>().lambda().eq(TeamPro::getTeamId, teamId));
        ResultUtil<Object> success = ResultUtil.success(Constant.SELECT_SUCCESS);
        success.setCount(proPage.getTotal());
        success.setData(proPage.getRecords());
        return success;
    }

    @RequestMapping("/toTeamProAdd")
    public ModelAndView toTeamProAdd(Integer teamId){
        User user = getUser();
        ModelAndView mv = new ModelAndView(thyme + "/team/teamProAdd");
        mv.addObject("teamId",teamId);
        List<Project> projectList = iProjectService.list(new QueryWrapper<Project>().lambda().eq(Project::getCreateId, user.getUserId()));
        mv.addObject("projectList",projectList);
        return mv;
    }

    @Log(value = "添加团队项目",type = "add")
    @RequestMapping("/teamProAdd")
    public ResultUtil teamProAdd(TeamPro teamPro){
        teamPro.setCreateTime(LocalDateTime.now());
        List<TeamPro> teamProList = iTeamProService.list(new QueryWrapper<TeamPro>().lambda().eq(TeamPro::getTeamId, teamPro.getTeamId()));
        for (TeamPro pro : teamProList) {
            if (pro.getProjectId() == teamPro.getProjectId()){
                return ResultUtil.error("添加失败！该项目已存在！");
            }
        }
        Project project = iProjectService.getById(teamPro.getProjectId());
        teamPro.setProjectName(project.getProName());
        return ResultUtil.flag(iTeamProService.save(teamPro));
    }

    @Log(value = "删除团队项目",type = "del")
    @RequestMapping("/deleteOne")
    public ResultUtil deleteOne(Integer teamProId){
        return ResultUtil.flag(iTeamProService.removeById(teamProId));
    }





}
