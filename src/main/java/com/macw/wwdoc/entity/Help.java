package com.macw.wwdoc.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Macw
 * @since 2020-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_help")
public class Help implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 帮助主键
     */
    @TableId(value = "help_id", type = IdType.AUTO)
    private Integer helpId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 作者name
     */
    private String createName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建时间
     */
    @TableField(exist = false)
    private String time;


    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 状态，1启用，0删除
     */
    private Integer state;


}
