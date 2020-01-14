package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.Project;
import com.macw.wwdoc.mapper.ProjectMapper;
import com.macw.wwdoc.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目管理表 服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

}
