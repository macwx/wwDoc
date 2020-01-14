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
 * 
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    /**
     * 标识(1主控制台,2接口平台)
     */
    private Integer identify;

    /**
     * 父级id
     */
    private Integer pid;

    /**
     * 路径
     */
    private String path;

    /**
     * 名称
     */
    private String title;

    /**
     * icon图标
     */
    private String icon;

    /**
     * 状态(0隐藏,1显示)
     */
    private Boolean status;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 是否删除(1已删除,2未删除)
     */
    private Boolean isdel;


}
