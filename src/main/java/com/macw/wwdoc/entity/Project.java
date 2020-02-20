package com.macw.wwdoc.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目管理表
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目表主键id
     */
    @TableId(value = "pro_id", type = IdType.AUTO)
    private Integer proId;

    /**
     * 项目名称
     */
    private String proName;

    /**
     * 项目描述
     */
    private String despection;

    /**
     * 项目访问密码
     */
    private String password;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新人id
     */
    private Integer updateId;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 0可用，1已删除
     */
    @TableLogic
    private Integer isDel;

    /**
     * 是否公开，0私密，1公开
     */
    private Integer isPub;


}
