package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.Team;
import com.macw.wwdoc.mapper.TeamMapper;
import com.macw.wwdoc.service.ITeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 团队主表 服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements ITeamService {

}
