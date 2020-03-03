package com.macw.wwdoc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 自定模板表
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_template")
public class Template implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模板主键id
     */
    @TableId(value = "template_id", type = IdType.AUTO)
    private Integer templateId;

    /**
     * 模板标题
     */
    private String title;

    /**
     * 内容
     */
    private String context;

    /**
     * 创建人name
     */
    private String createUser;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
