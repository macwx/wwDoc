package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.Team;
import com.macw.wwdoc.entity.TeamMember;
import com.macw.wwdoc.entity.TeamPro;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.ITeamMemberService;
import com.macw.wwdoc.service.ITeamProService;
import com.macw.wwdoc.service.ITeamService;
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
 * 团队主表 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@RestController
@RequestMapping("/team")
public class TeamController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ITeamService iTeamService;

    @Resource
    private ITeamMemberService iTeamMemberService;

    @Resource
    private ITeamProService iTeamProService;

    @RequestMapping("/toTeamList")
    public ModelAndView toTeamList() {
        ModelAndView mv = new ModelAndView(thyme + "/team/teamList");
        return mv;
    }

    @RequestMapping("/toTeamEdit")
    public ModelAndView toTeamEdit() {
        ModelAndView mv = new ModelAndView(thyme + "/team/teamEdit");
        return mv;
    }

    @RequestMapping("/listTeam")
    public ResultUtil listTeam(int page, int limit, String title) {
        User user = getUser();
        Page<Team> teamPage = new Page<>(page, limit);
        Page<Team> iPage = iTeamService.page(teamPage, new QueryWrapper<Team>().lambda()
                .eq(Team::getCreateId, user.getUserId())
                .like(StringUtils.isNotBlank(title),Team::getTeamName, title));
        List<Team> records = iPage.getRecords();
        for (Team team : records) {
            List<TeamMember> list = iTeamMemberService.list(new QueryWrapper<TeamMember>().lambda().eq(TeamMember::getTeamId, team.getTeamId()));
            team.setMemberNumber(list.size());
            List<TeamPro> teamProList = iTeamProService.list(new QueryWrapper<TeamPro>().lambda().eq(TeamPro::getTeamId, team.getTeamId()));
            team.setProNumber(teamProList.size());
        }
        ResultUtil<Object> success = ResultUtil.success(Constant.SELECT_SUCCESS);
        success.setCount(iPage.getTotal());
        success.setData(records);
        return success;
    }

    @RequestMapping("/editTeam")
    public ResultUtil editTeam(Team team) {
        User user = getUser();
        team.setCreateTime(LocalDateTime.now());
        if (IntegerUtils.isBlank(team.getTeamId())) {
            team.setCreateId(user.getUserId());
            team.setCreateUser(user.getUserName());
            return ResultUtil.flag(iTeamService.save(team));
        } else {
            return ResultUtil.flag(iTeamService.updateById(team));
        }
    }

    @RequestMapping("/deleteOne")
    public ResultUtil deleteOne(Integer teamId) {
        boolean remove = iTeamProService.remove(new QueryWrapper<TeamPro>().lambda().eq(TeamPro::getTeamId, teamId));
        boolean remove1 = iTeamMemberService.remove(new QueryWrapper<TeamMember>().lambda().eq(TeamMember::getTeamId, teamId));
        boolean b = iTeamService.removeById(teamId);
        if (remove && remove1 && b) {
            return ResultUtil.flag(true);
        } else {
            return ResultUtil.flag(false);
        }
    }

}
