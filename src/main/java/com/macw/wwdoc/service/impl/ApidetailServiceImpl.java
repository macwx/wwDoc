package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.Apidetail;
import com.macw.wwdoc.entity.vo.MenuVo;
import com.macw.wwdoc.mapper.ApidetailMapper;
import com.macw.wwdoc.service.IApidetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文章详情表 服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Service
public class ApidetailServiceImpl extends ServiceImpl<ApidetailMapper, Apidetail> implements IApidetailService {

    @Override
    public List<MenuVo> listMenuVo(Integer proId) {
        List<MenuVo> menuVos = this.baseMapper.listMenuVo(proId);
        for (MenuVo menuVo : menuVos) {
            menuVo.setHref("/apidetail/apiView?apiId="+menuVo.getMenuId());
        }
        return menuVos;
    }
}
