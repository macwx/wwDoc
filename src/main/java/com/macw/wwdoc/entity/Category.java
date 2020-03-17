package com.macw.wwdoc.entity;

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
 * 文章分类表
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章分类主键id
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 上级目录
     */
    private Integer parentId;

    /**
     * 排序号，逆序
     */
    private Integer sort;

    /**
     * 菜单级别
     */
    private Integer level;

    /**
     * 路径地址
     */
    private String url;

    /**
     * 图标
     */
    private String icon;


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


}
