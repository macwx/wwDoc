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
 * 文章详情表
 * </p>
 *
 * @author Macw
 * @since 2020-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章主键id
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 所属项目id
     */
    private Integer projectId;

    /**
     * 所属分类id
     */
    private Integer categoryId;

    /**
     * 文章描述
     */
    private String despection;

    /**
     * 请求地址
     */
    private String getUrl;

    /**
     * 请求类型
     */
    private String getType;

    /**
     * 请求参数
     */
    private String getParam;

    /**
     * 返回实例
     */
    private String returnContext;

    /**
     * 返回参数说明
     */
    private String returnParam;

    /**
     * 文章备注
     */
    private String remark;

    /**
     * 发布时间
     */
    private LocalDateTime createTime;

    /**
     * 发布人
     */
    private String createUser;

    /**
     * 发布人id
     */
    private Integer createId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 更新人id
     */
    private Integer updateId;

    /**
     * 版本号
     */
    private String version;

    /**
     * 是否删除，0可用，1已删除
     */
    private Integer isDel;


}
