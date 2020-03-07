package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.config.Log;
import com.macw.wwdoc.entity.TeamMember;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.ITeamMemberService;
import com.macw.wwdoc.service.ITeamService;
import com.macw.wwdoc.service.IUserService;
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
 * 团队成员表 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@RestController
@RequestMapping("/teamMember")
public class TeamMemberController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ITeamService iTeamService;

    @Resource
    private ITeamMemberService iTeamMemberService;

    @Resource
    private IUserService iUserService;

    @RequestMapping("/toTeamMemList")
    public ModelAndView toTeamMemList(Integer teamId){
        ModelAndView mv = new ModelAndView(thyme + "/team/teamMemberList");
        mv.addObject("teamId",teamId);
        return mv;
    }

    @RequestMapping("/listTeamMember")
    public ResultUtil listTeamMember(int page,int limit,Integer teamId){
        Page<TeamMember> teamMemberPage = new Page<>(page, limit);
        Page<TeamMember> memberPage = iTeamMemberService.page(teamMemberPage, new QueryWrapper<TeamMember>().lambda()
                .eq(TeamMember::getTeamId, teamId));
        ResultUtil<Object> success = ResultUtil.success(Constant.SELECT_SUCCESS);
        success.setCount(memberPage.getTotal());
        success.setData(memberPage.getRecords());
        return success;
    }


    @RequestMapping("/toAddTM")
    public ModelAndView toAddTM(Integer teamId){
        ModelAndView mv = new ModelAndView(thyme + "/team/teamMemberAdd");
        mv.addObject("teamId",teamId);
        return mv;
    }

    @Log(value = "添加团队成员",type = "add")
    @RequestMapping("/addTeamMember")
    public ResultUtil addTeamMember(TeamMember teamMember){
        teamMember.setCreateTime(LocalDateTime.now());
        User user = iUserService.getOne(new QueryWrapper<User>().lambda().eq(User::getUserName, teamMember.getUserName()));
        if (user==null){
            ResultUtil.error("您输入的用户名为空！");
        }
        List<TeamMember> teamMemberList = iTeamMemberService.list(new QueryWrapper<TeamMember>().lambda().eq(TeamMember::getTeamId, teamMember.getTeamId()));
        for (TeamMember member : teamMemberList) {
            if (member.getUserId()==user.getUserId()){
                return ResultUtil.error("该用户已存在于您的团队！请勿重复加入");
            }
        }
        teamMember.setUserId(user.getUserId());
        teamMember.setNickname(user.getNickname());
        return ResultUtil.flag(iTeamMemberService.save(teamMember));
    }

    @Log(value = "更新团队成员",type = "update")
    @RequestMapping("/teamMemberEdit")
    public ResultUtil teamMemberEdit(TeamMember teamMember){
        return ResultUtil.flag(iTeamMemberService.updateById(teamMember));
    }

    @Log(value = "删除团队成员",type = "del")
    @RequestMapping("/deleteOne")
    public ResultUtil deleteOne(Integer teamMemberId){
        return ResultUtil.flag(iTeamMemberService.removeById(teamMemberId));
    }


}
