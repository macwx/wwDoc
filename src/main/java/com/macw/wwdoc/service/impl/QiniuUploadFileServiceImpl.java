package com.macw.wwdoc.service.impl;

import com.macw.wwdoc.entity.vo.Ret;
import com.macw.wwdoc.service.IQiniuUploadFileService;
import com.macw.wwdoc.util.DateUtil;
import com.macw.wwdoc.util.UUIDUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDateTime;

/**
 * @author Macw
 * @version 1.0
 * @date 2020/2/29 15:54
 */
@Service
public class QiniuUploadFileServiceImpl implements IQiniuUploadFileService, InitializingBean {

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Auth auth;

    @Value("${qiniu.Bucket}")
    private String bucket;

    @Value("${qiniu.prefix}")
    private String prefix;

    /**
     * 定义七牛云上传的相关策略
     */
    private StringMap putPolicy;


    /**
     * 以文件的形式上传
     *
     * @param file
     * @return
     * @throws QiniuException
     */
    @Override
    public String uploadFile(File file) throws QiniuException {
        Response response = this.uploadManager.put(file, null, getUploadToken());
        int retry = 0;
        while (response.needRetry() && retry < 3) {
            response = this.uploadManager.put(file, null, getUploadToken());
            retry++;
        }
        return getUrl(response);
    }

    /**
     * 以流的形式上传
     *
     * @param inputStream
     * @return
     * @throws QiniuException
     */
    @Override
    public String uploadFile(InputStream inputStream) throws QiniuException {
        Response response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
        int retry = 0;
        while (response.needRetry() && retry < 3) {
            response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
            retry++;
        }
        return getUrl(response);
    }

    /**
     * 删除七牛云上的相关文件
     *
     * @param key
     * @return
     * @throws QiniuException
     */
    @Override
    public String delete(String key) throws QiniuException {
        Response response = bucketManager.delete(this.bucket, key);
        int retry = 0;
        while (response.needRetry() && retry++ < 3) {
            response = bucketManager.delete(bucket, key);
        }
        return getUrl(response);
    }

    private String getUrl(Response response) throws QiniuException {
        if (response.isOK()) {
            Ret ret = response.jsonToObject(Ret.class);
            return prefix + ret.key;
        } else {
            return null;
        }
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        //自定义上传策略，详情可以参考七牛云的官方文档https://developer.qiniu.com/kodo/manual/1206/put-policy
        putPolicy.put("saveKey", DateUtil.dateFormat(LocalDateTime.now(), "yyyy/MM/dd/HH/mm/ss")+"/"+UUIDUtil.getUUID().substring(24));
//        putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width), \"height\":${imageInfo.height}}");
    /*    putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize),\"user\":\"$(x:user)\",\"age\",$(x:age)}");
        putPolicy.put("callbackUrl", "http://henaumcw.51vip.biz/FileUpload/callBack");
*/

    }

    /**
     * 获取上传凭证
     *
     * @return
     */
    private String getUploadToken() {
        return this.auth.uploadToken(bucket, null, 3600, putPolicy);
    }

}
