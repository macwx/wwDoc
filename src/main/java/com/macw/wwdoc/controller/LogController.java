package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.Log;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.ILogService;
import com.macw.wwdoc.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.macw.wwdoc.controller.BaseController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-03-06
 */
@RestController
@RequestMapping("/log")
public class LogController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ILogService iLogService;

    @RequestMapping("/toLogList")
    public ModelAndView toLogList() {
        ModelAndView mv = new ModelAndView(thyme + "/logs/logList");
        return mv;
    }

    @RequestMapping("/listLog")
    public ResultUtil listLog(int page, int limit, String title) {
        User user = getUser();
        Page<Log> logPage = new Page<>(page, limit);
        Page<Log> page1 = iLogService.page(logPage, new QueryWrapper<Log>().lambda().eq(Log::getLogUserId, user.getUserId())
                .like(StringUtils.isNotBlank(title), Log::getLogContent, title).or()
                .like(Log::getLogType, title));
        ResultUtil<Object> success = ResultUtil.success(Constant.SELECT_SUCCESS);
        success.setCount(page1.getTotal());
        success.setData(page1.getRecords());
        return success;
    }

}
