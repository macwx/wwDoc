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
 * 团队成员表
 * </p>
 *
 * @author Macw
 * @since 2020-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_team_member")
public class TeamMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 团队成员主键id
     */
    @TableId(value = "team_member_id", type = IdType.AUTO)
    private Integer teamMemberId;

    /**
     * 团队id
     */
    private Integer teamId;

    /**
     * 成员id
     */
    private Integer userId;

    /**
     * 成员name
     */
    private String userName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
