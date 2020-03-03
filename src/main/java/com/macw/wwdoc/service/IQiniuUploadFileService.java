package com.macw.wwdoc.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author Macw
 * @version 1.0
 * @date 2020/2/29 15:52
 */
public interface IQiniuUploadFileService {

    /**
     * File 文件上传
     * @param file
     * @return
     * @throws QiniuException
     */
     String uploadFile(File file) throws QiniuException;

    /**
     * File 文件上传
     * @param file
     * @return
     * @throws Exception
     */
     String uploadFile(MultipartFile file) throws  Exception;

    /**
     * 流形势文件上传
     * @param inputStream
     * @return
     * @throws QiniuException
     */
    String uploadFile(InputStream inputStream) throws QiniuException;

    /**
     * 删除文件
     * @param key
     * @return
     * @throws QiniuException
     */
    String delete(String key) throws QiniuException;

}
