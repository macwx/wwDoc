package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.Config;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.IConfigService;
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


/**
 * <p>
 * 参数配置表 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-03-04
 */
@RestController
@RequestMapping("/config")
public class ConfigController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IConfigService iConfigService;

    @RequestMapping("/toConfig")
    public ModelAndView toConfig() {
        return new ModelAndView(thyme + "/config/configList");
    }

    @RequestMapping("/toConfigAdd")
    public ModelAndView toConfigAdd() {
        return new ModelAndView(thyme + "/config/configAdd");
    }


    @RequestMapping("/listConfig")
    public ResultUtil listConfig(int page, int limit, String title) {
        Page<Config> configPage = new Page<>(page, limit);
        Page<Config> page1 = iConfigService.page(configPage, new QueryWrapper<Config>().lambda()
                .like(StringUtils.isNotBlank(title), Config::getConfigKey, title)
                .or()
                .like(StringUtils.isNotBlank(title), Config::getConfigName, title));
        ResultUtil<Object> success = ResultUtil.success(Constant.SELECT_SUCCESS);
        success.setCount(page1.getTotal());
        success.setData(page1.getRecords());
        return success;
    }

    @RequestMapping("/saveOrUpdate")
    public ResultUtil saveOrUpdate(Config config){
        logger.debug("config---="+config);
        User user = getUser();
        if (IntegerUtils.isBlank(config.getConfigId())){
            config.setCreateTime(LocalDateTime.now());
            config.setCreateUser(user.getUserName());
            return ResultUtil.flag(iConfigService.save(config));
        }else {
            config.setUpdateTime(LocalDateTime.now());
            config.setUpdateUser(user.getUserName());
            return ResultUtil.flag(iConfigService.updateById(config));
        }
    }

    @RequestMapping("/deleteOne")
    public ResultUtil deleteOne(Integer configId){
        return ResultUtil.flag(iConfigService.removeById(configId));
    }

}
