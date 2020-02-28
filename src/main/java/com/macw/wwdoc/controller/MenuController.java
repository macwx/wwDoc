package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macw.wwdoc.entity.Menu;
import com.macw.wwdoc.entity.vo.MenuVo;
import com.macw.wwdoc.mapper.MenuMapper;
import com.macw.wwdoc.service.IMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IMenuService iMenuService;

    @RequestMapping("/index")
    public Map index(){
        MenuVo menuVo = iMenuService.listMenuVo(1,"控制台","fa fa-home");
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        map2.put("control", menuVo);
        map.put("menuInfo",map2);
        return map;
    }

    @RequestMapping("/doc")
    public Map doc(Integer identify){
        Map<String,Object> map = new HashMap<>();
        MenuVo menuVo2 = iMenuService.listMenuVo(2,"返回项目列表","fa fa-undo");
        Map<String,Object> map2 = new HashMap<>(16);
        map2.put("docs", menuVo2);
        map.put("menuInfo",map2);
        return map;
    }
}
