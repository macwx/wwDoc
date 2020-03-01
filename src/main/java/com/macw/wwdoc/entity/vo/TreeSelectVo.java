package com.macw.wwdoc.entity.vo;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author Macw
 * @version 1.0
 * 下拉树形选择器
 * @date 2020/2/28 17:15
 */
@Data
public class TreeSelectVo {

    private String id;
    private String name;
    private Boolean open;
    private List<TreeSelectVo> children;
    private Boolean checked;
}
