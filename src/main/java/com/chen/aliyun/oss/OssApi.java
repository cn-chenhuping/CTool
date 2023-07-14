package com.chen.aliyun.oss;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.chen.aliyun.oss.model.ConstantPropertiesUtils;
import com.chen.utils.file.FileUploadUtils;
import com.chen.utils.file.MimeTypeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 关于阿里云OSS文件上传存储操作API封装
 * @author chenhuping
 */
@Slf4j
@EnableConfigurationProperties(ConstantPropertiesUtils.class)
public class OssApi {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    static SimpleDateFormat sdfs = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 获取oss
     * @return
     */
    public static OSSClient getOssClient() {
        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
        //创建OSSClient对象
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        //判断仓库是否存在
        if (ossClient.doesBucketExist(bucketName)) {
            log.info("bucket存在");
        } else {
            // 通过api创建bucket仓库
            log.info("bucket不存在，创建新的bucket" + bucketName);
            CreateBucketRequest bucketRequest = new CreateBucketRequest(null);
            bucketRequest.setBucketName(bucketName);
            bucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
            ossClient.createBucket(bucketRequest);
        }
        return ossClient;
    }

    /**
     * 上传文件-oss
     * @param file
     * @return 文件存储格式为：https://桶端点.阿里云地址/文件夹/年/月/日/img.png
     */
    public static String file(MultipartFile file) {
        OSS ossClient = getOssClient();
        try {
            //校验文件
            FileUploadUtils.assertAllowed(file, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
            //获取原始文件名
            String fileName = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            //唯一文件名
            String originalFilename = UUID.randomUUID().toString().replace("-", "") + fileName;
            //当天文件目录
            String format = sdf.format(new Date());
            originalFilename = ConstantPropertiesUtils.FILE_NAME + "/" + format + "/" + originalFilename;
            ossClient.putObject(ConstantPropertiesUtils.BUCKET_NAME, originalFilename, inputStream);
            return "https://" + ConstantPropertiesUtils.BUCKET_NAME + "." + ConstantPropertiesUtils.END_POINT + "/" + originalFilename;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * 删除文件-oss
     * @param url
     * @return
     */
    public static boolean deleteFile(String url) {
        OSS ossClient = getOssClient();
        try {
            // 删除文件。
            String urls = url.replace("https://" + ConstantPropertiesUtils.BUCKET_NAME + "." + ConstantPropertiesUtils.END_POINT + "/", "");
            ossClient.deleteObject(ConstantPropertiesUtils.BUCKET_NAME, urls);
            return true;
        } catch (OSSException oe) {
            System.out.println("捕获OSSException，这意味着您的请求已发送到OSS, "
                    + "但由于某种原因被拒绝并返回错误响应.");
            System.out.println("错误消息:" + oe.getErrorMessage());
            System.out.println("错误代码:" + oe.getErrorCode());
            System.out.println("请求ID:" + oe.getRequestId());
            System.out.println("主机ID:" + oe.getHostId());
            return false;
        } catch (ClientException ce) {
            System.out.println("捕获了ClientException，这意味着客户端在尝试与OSS通信时遇到了严重的内部问题，例如无法访问网络。");
            System.out.println("错误消息:" + ce.getMessage());
            return false;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

}
