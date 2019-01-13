package com.breach.huajinbao.util.global;

import com.aliyun.oss.OSSClient;
import com.breach.huajinbao.sysconst.api.IApiConsts;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.Date;

/**
 * @program: Financial
 * @description: 阿里 OSS 对象存储工具
 * @author: shaokang
 * @create: 2019-01-12 13:49
 **/
public class AliOSSUtil {

    public static String upload(MultipartFile multipartFile, String username) throws Exception {
        // 获取上传的文件类型 后缀名
        String originalFilename = multipartFile.getOriginalFilename();
        String prefix = originalFilename.substring(originalFilename.lastIndexOf("."));

        // 配置上传条件
        String endpoint = IApiConsts.ALI_OSS_ENDPOINT;
        String accessKeyId = IApiConsts.ALI_OSS_ACCESS_KEY_ID;
        String accessKeySecret = IApiConsts.ALI_OSS_ACCESS_KEY_SECRET;
        String bucketName = IApiConsts.ALI_OSS_BUCKET_NAME;
        String objectName = "verify/" + username + "/" + SerialUtil.getDateTimeUUID() + prefix;

        System.out.println("创建oss实例");
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        System.out.println("上传到指定位置");
        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(multipartFile.getBytes()));

        System.out.println("关闭oss对象");
        // 关闭OSSClient。
        ossClient.shutdown();

        // 获取文件的访问路径 访问url
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        String url = ossClient.generatePresignedUrl(bucketName, objectName, expiration).toString();

        return url;
    }
}
