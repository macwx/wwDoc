package com.macw.wwdoc;

import cn.afterturn.easypoi.word.WordExportUtil;
import com.macw.wwdoc.entity.vo.Ret;
import com.macw.wwdoc.service.IQiniuUploadFileService;
import com.macw.wwdoc.util.DateUtil;
import com.macw.wwdoc.util.UUIDUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Macw
 * @version 1.0
 * @date 2020/2/29 15:59
 */

@SpringBootTest(classes = WwdocApplication.class)
@RunWith(SpringRunner.class)
public class qiniuTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IQiniuUploadFileService iQiniuUploadFileService;

    @Test
    public void fileUploadTest() throws QiniuException {

        String url = iQiniuUploadFileService.uploadFile(new File("F:\\git\\trmplate.docx"));
        System.out.println("---" + url);
    }

    public static void main(String[] args) {
        String s = DateUtil.dateFormat(LocalDateTime.now(), "yyyy/MM/dd/HH/mm/ss");
        System.out.println(s);
        System.out.println(UUIDUtil.getUUID());
        System.out.println(UUIDUtil.getUUID().substring(10));
    }


    /**
     * 简单导出没有图片和Excel
     */
    @Test
    public void SimpleWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("department", "Easypoi");
        map.put("person", "JueYue");
        map.put("time", new Date());
        map.put("me", "JueYue");
        map.put("date", "2015-01-03");
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                    "cn/afterturn/easypoi/test/word/doc/Simple.docx", map);
            FileOutputStream fos = new FileOutputStream("D:/excel/simple.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
