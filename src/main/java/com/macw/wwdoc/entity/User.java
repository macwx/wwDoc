package com.macw.wwdoc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键id
     */
    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 1启用，0禁用
     */
    private Integer state;


}
