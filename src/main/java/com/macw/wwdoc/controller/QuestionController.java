package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.Question;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.IQuestionService;
import com.macw.wwdoc.util.IntegerUtils;
import com.macw.wwdoc.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.macw.wwdoc.controller.BaseController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-03-10
 */
@RestController
@RequestMapping("/question")
public class QuestionController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IQuestionService iQuestionService;

    @RequestMapping("/toQuestionList")
    public ModelAndView toQuestion(){
        return new ModelAndView(thyme+"/question/questionList");
    }

    @RequestMapping("/listQuestion")
    public ResultUtil listQuestion(int page,int limit,String title){
        User user = getUser();
        Page<Question> page1 = iQuestionService.page(new Page<Question>(page, limit), new QueryWrapper<Question>().lambda()
                .eq(Question::getCreateId, user.getUserId())
                .like(StringUtils.isNotBlank(title), Question::getTitle, title));
        ResultUtil<Object> success = ResultUtil.success(Constant.SELECT_SUCCESS);
        success.setCount(page1.getTotal());
        success.setData(page1.getRecords());
        return success;
    }

    @RequestMapping("/toQuestionAdd")
    public ModelAndView toQuestionAdd(){
        return new ModelAndView(thyme+"/question/questionEdit");
    }

    @RequestMapping("/editQuestion")
    public ResultUtil editQuestion(Question question){
        User user = getUser();
        if (IntegerUtils.isBlank(question.getQuestionId())) {
            question.setCreateId(user.getUserId());
            question.setCreateName(user.getNickname());
            question.setCreateTime(LocalDateTime.now());
            return ResultUtil.flag(iQuestionService.save(question));
        }else {
            return ResultUtil.flag(iQuestionService.updateById(question));
        }
    }


    @RequestMapping("/deleteOne")
    public ResultUtil deleteOne(Integer questionId){
        return ResultUtil.flag(iQuestionService.removeById(questionId));
    }

    @RequestMapping("/toQuestionDetail")
    public ModelAndView toQuestionDetail(Integer questionId){
        ModelAndView mv = new ModelAndView(thyme + "/question/questionInfo");
        Question question = iQuestionService.getById(questionId);
        mv.addObject("question",question);
        return mv;
    }



}
