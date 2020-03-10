package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macw.wwdoc.entity.Config;
import com.macw.wwdoc.entity.Menu;
import com.macw.wwdoc.entity.vo.MenuVo;
import com.macw.wwdoc.mapper.MenuMapper;
import com.macw.wwdoc.service.IConfigService;
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

    @Resource
    private IConfigService iConfigService;

    @RequestMapping("/index")
    public Map index(){
        MenuVo menuVo = iMenuService.listMenuVo(1,"控制台","fa fa-home");
        Map<String,Object> map2 = new HashMap<>(16);
        map2.put("control", menuVo);
        Map map = info();
        map.put("menuInfo",map2);
        return map;
    }

    private Map info(){
        Config clearUrl = iConfigService.getOne(new QueryWrapper<Config>().lambda().eq(Config::getConfigKey, "clearUrl"));
        Map<String,Object> clearUrlMap = new HashMap<>(16);
        clearUrlMap.put("clearUrl", clearUrl.getConfigValue());

        Map<String,Object> homeInfoMap = new HashMap<>(16);
        homeInfoMap.put("title", "首页");
        homeInfoMap.put("icon", "fa fa-home");
        homeInfoMap.put("href", "/user/toWelcome");

        Config logoImage = iConfigService.getOne(new QueryWrapper<Config>().lambda().eq(Config::getConfigKey, "logoImage"));
        Map<String,Object> logoInfoMap = new HashMap<>(16);
        logoInfoMap.put("title", "wwDoc");
        logoInfoMap.put("href", "/user/toWelcome");
        logoInfoMap.put("image", logoImage.getConfigValue());

        Map<String,Object> map = new HashMap<>(16);
        map.put("clearInfo", clearUrlMap);
        map.put("homeInfo",homeInfoMap);
        map.put("logoInfo", logoInfoMap);
        return map;

    }

    @RequestMapping("/doc")
    public Map doc(Integer identify){
        MenuVo menuVo2 = iMenuService.listMenuVo(2,"返回项目列表","fa fa-undo");
        Map<String,Object> map2 = new HashMap<>(16);
        map2.put("docs", menuVo2);

        Map map = info();
        map.put("menuInfo",map2);
        return map;
    }
}
