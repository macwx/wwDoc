package com.macw.wwdoc;

import com.macw.wwdoc.entity.vo.Ret;
import com.macw.wwdoc.service.IQiniuUploadFileService;
import com.macw.wwdoc.util.DateUtil;
import com.macw.wwdoc.util.UUIDUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.time.LocalDateTime;

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

        String url = iQiniuUploadFileService.uploadFile(new File("F:\\git\\logo2.png"));
        System.out.println("---"+url);
    }

    public static void main(String[] args) {
        String s = DateUtil.dateFormat(LocalDateTime.now(), "yyyy/MM/dd/HH/mm/ss");
        System.out.println(s);
        System.out.println(UUIDUtil.getUUID());
        System.out.println(UUIDUtil.getUUID().substring(10));
    }

}
