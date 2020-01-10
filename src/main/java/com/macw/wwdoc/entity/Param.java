package com.macw.wwdoc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 请求参数表
 * </p>
 *
 * @author Macw
 * @since 2020-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_param")
public class Param implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 参数主键id
     */
    @TableId(value = "param_id", type = IdType.AUTO)
    private Integer paramId;

    /**
     * 参数标识
     */
    private String paramKey;

    /**
     * 参数名称
     */
    private String paramName;

    /**
     * 是否必选，1必选，0非必选
     */
    private Integer isChoose;

    /**
     * 参数类型
     */
    private String paramType;

    /**
     * 参数说明
     */
    private String paramDesp;


}
