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
 * @since 2020-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_apidetail")
public class Apidetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章主键id
     */
    @TableId(value = "apidetail_id", type = IdType.AUTO)
    private Integer apidetailId;

    /**
     * 所属项目id
     */
    private Integer projectId;

    /**
     * 所属分类id
     */
    private Integer categoryId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章描述
     */
    private String despection;

    /**
     * 请求地址
     */
    private String getway;

    /**
     * 请求方法(1GET,2POST,3PUT,4DELETE)
     */
    private Integer method;

    /**
     * 请求类型(1json,2xml,3form,4raw)
     */
    private Integer requesttype;

    /**
     * 响应类型(1json,2xml,3jsonp,4html)
     */
    private Integer responsetype;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 响应参数
     */
    private String responseParam;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 成功示例
     */
    private String successGoback;

    /**
     * 失败示例
     */
    private String failGoback;

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
     * 1启用，0废弃
     */
    private Integer state;

    /**
     * 是否删除，0可用，1已删除
     */
    private Integer isDel;


}
