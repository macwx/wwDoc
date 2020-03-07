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
 * 
 * </p>
 *
 * @author Macw
 * @since 2020-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志主键id
     */
    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 操作人id
     */
    private Integer logUserId;

    /**
     * 操作人ip
     */
    private String logIp;

    /**
     * 操作时间
     */
    private LocalDateTime logDate;

    /**
     * 操作内容
     */
    private String logContent;


}
