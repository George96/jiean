package com.jiean.common.utils.aliyun;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author : george
 */

public class AliyunOssProperties implements InitializingBean {

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.ossBucketName}")
    private String ossBucketName;
    @Value("${aliyun.oss.ossEndpoint}")
    private String ossEndpoint;
    @Value("${aliyun.oss.fileHost}")
    private String fileHost;


    public static String ACCESS_KEY_ID;

    public static String ACCESS_KEY_SECRET;

    public static String OSS_BUCKET_NAME;

    public static String OSS_END_POINT;

    public static String FILE_HOST;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY_ID=accessKeyId;
        ACCESS_KEY_SECRET=accessKeySecret;
        OSS_BUCKET_NAME=ossBucketName;
        OSS_END_POINT=ossEndpoint;
        FILE_HOST=fileHost;
    }

}
