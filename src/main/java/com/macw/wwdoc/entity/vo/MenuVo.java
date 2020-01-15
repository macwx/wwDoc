package com.macw.wwdoc.entity.vo;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author 马超伟
 * @PROJECT_NAME: wwdoc
 * @Description:
 * @date 18:30
 * @Copyright: All rights Reserved, Designed By Huerdai  
 * Copyright:    Copyright(C) 2019-2020
 * Company       Huerdai Henan LTD.
 */

/**
 * 首页菜单
 */
@Data
public class MenuVo {

    private String title;
    private String icon;
    private String href;
    private String target;
    private List<MenuVo> child;

}
