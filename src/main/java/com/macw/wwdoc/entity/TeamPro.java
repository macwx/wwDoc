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
 * 团队项目表
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_team_pro")
public class TeamPro implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 团队项目关联表主键id
     */
    @TableId(value = "team_pro_id", type = IdType.AUTO)
    private Integer teamProId;

    /**
     * 团队主键id
     */
    private Integer teamId;

    /**
     * 项目主键id
     */
    private Integer projectId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
