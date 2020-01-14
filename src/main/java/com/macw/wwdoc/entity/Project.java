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
     * 0可用，1已删除
     */
    private Integer isDel;


}
