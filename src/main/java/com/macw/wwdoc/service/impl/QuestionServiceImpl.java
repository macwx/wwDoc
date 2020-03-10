package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.Question;
import com.macw.wwdoc.mapper.QuestionMapper;
import com.macw.wwdoc.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Macw
 * @since 2020-03-10
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
