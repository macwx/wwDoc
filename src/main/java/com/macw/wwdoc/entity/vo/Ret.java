package com.macw.wwdoc.entity.vo;

import lombok.Data;

/**
 * @author Macw
 * @version 1.0
 * @date 2020/2/29 18:18
 * 七牛，返回值工具类
 */
@Data
public class Ret {
    public long fsize;
    public String key;
    public String hash;
    public int w;
    public int h;
}
