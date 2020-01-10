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
 * api文档附件
 * </p>
 *
 * @author Macw
 * @since 2020-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("api_upload_file")
public class UploadFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件主键id
     */
    @TableId(value = "file_id", type = IdType.AUTO)
    private Integer fileId;

    /**
     * 文件签名标识
     */
    private String sign;

    /**
     * 文件名
     */
    private String displayName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 项目id
     */
    private Integer proId;

    /**
     * 文件请求路径
     */
    private String url;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
