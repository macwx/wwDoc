package com.macw.wwdoc.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 */
public class DigestUtils {
    // 获取md5加密算法对象
    private final static MessageDigest md;
    private final static char[] cs = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static {
        try {
            md = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String md5(String text) {
        try {
            byte[] bs = md.digest(text.getBytes("utf-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : bs) {
                sb.append(cs[(b >> 4) & 0x0f]);
                sb.append(cs[b & 0x0f]);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    //测试
    public static void main(String[] args) {
        System.out.println(md5("hello world"));
    }
}

