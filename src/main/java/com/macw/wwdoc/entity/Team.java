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
 * 团队主表
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_team")
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 团队主键id
     */
    @TableId(value = "team_id", type = IdType.AUTO)
    private Integer teamId;

    /**
     * 团队名称
     */
    private String teamName;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 创建人name
     */
    private String createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
