package com.macw.wwdoc.controller;

import com.alibaba.fastjson.JSONObject;
import com.macw.wwdoc.service.IQiniuUploadFileService;
import com.macw.wwdoc.util.FileUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public JSONObject fileUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach) {
        JSONObject jsonObject = new JSONObject();
        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");

            String url = iQiniuUploadFileService.uploadFile(attach);
            // 下面response返回的json格式是editor.md所限制的，规范输出就OK

            jsonObject.put("success", 1);
            jsonObject.put("message", "上传成功");
            jsonObject.put("url", url);
        } catch (Exception e) {
            jsonObject.put("success", 0);
        }

        return jsonObject;

    }

    /**
     * 暂时不用
     *
     * @param request
     * @param response
     */
    @RequestMapping("/callBack")
    public void callBack(HttpServletRequest request, HttpServletResponse response) {
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


    /**
     * wangEditor图片上传
     * @param file
     * @return
     */
    @RequestMapping("/wangEditorUpload")
    public Map wangEditorUpload(MultipartFile file){
        Map map = new HashMap(16);
        try {
            String url = iQiniuUploadFileService.uploadFile(file);
            map.put("errno",0);
            List<String> list=new ArrayList<>();
            list.add(url);
            map.put("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("errno",1);
        }
        logger.debug("0-----------"+map);
        return map;


    }


}
