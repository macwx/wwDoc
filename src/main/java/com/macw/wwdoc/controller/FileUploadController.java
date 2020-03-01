package com.macw.wwdoc.controller;

import com.alibaba.fastjson.JSONObject;
import com.macw.wwdoc.entity.vo.Ret;
import com.macw.wwdoc.service.IQiniuUploadFileService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Macw
 * @version 1.0
 * @date 2020/2/29 16:23
 */
@RequestMapping("/FileUpload")
@RestController
public class FileUploadController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IQiniuUploadFileService iQiniuUploadFileService;

    @RequestMapping("/fileUpload")
    public String fileUpload(File file) throws QiniuException {
        String url = iQiniuUploadFileService.uploadFile(file);
        return url;
    }

    /**
     * 暂时不用
     * @param request
     * @param response
     */
    @RequestMapping("/callBack")
    public void callBack(HttpServletRequest request, HttpServletResponse response)  {
        try {
            // 接收七牛回调过来的内容
            String line = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            // 设置返回给七牛的数据
            logger.info(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
