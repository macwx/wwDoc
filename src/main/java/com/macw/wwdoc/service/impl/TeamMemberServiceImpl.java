package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.TeamMember;
import com.macw.wwdoc.mapper.TeamMemberMapper;
import com.macw.wwdoc.service.ITeamMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 团队成员表 服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-01-10
 */
@Service
public class TeamMemberServiceImpl extends ServiceImpl<TeamMemberMapper, TeamMember> implements ITeamMemberService {

}
