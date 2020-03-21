package com.macw.wwdoc.service;

import com.macw.wwdoc.entity.Apidetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macw.wwdoc.entity.vo.MenuVo;

import java.util.List;

/**
 * <p>
 * 文章详情表 服务类
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
public interface IApidetailService extends IService<Apidetail> {

    /**
     * 查询没有分类的API
     * @param proId
     * @return
     */
    List<MenuVo> listMenuVo(Integer proId);

}
