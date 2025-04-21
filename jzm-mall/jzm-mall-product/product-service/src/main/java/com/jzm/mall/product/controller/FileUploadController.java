package com.jzm.mall.product.controller;

import com.jzm.mall.common.result.Result;
import io.minio.*;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;


@RestController
@RequestMapping("admin/product")
public class FileUploadController {

    @Value("${minio.endpoint}")
    private String endpointUrl;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @Value("${minio.bucketName}")
    private String bucketName;

    @PostMapping("fileUpload")
    public Result fileUpload(@RequestParam("file") MultipartFile file) {
        try {

            MinioClient minioClient = MinioClient.builder()
                    .endpoint(endpointUrl)
                    .credentials(accessKey, secretKey)
                    .build();

            // 创建 bucket（如果不存在）
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!isExist) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());

                // 设置 bucket 为 public-read（首次创建时设置一次即可）
                String publicPolicy = "{\n" +
                        "  \"Version\": \"2012-10-17\",\n" +
                        "  \"Statement\": [\n" +
                        "    {\n" +
                        "      \"Effect\": \"Allow\",\n" +
                        "      \"Principal\": {\"AWS\": [\"*\"]},\n" +
                        "      \"Action\": [\"s3:GetObject\"],\n" +
                        "      \"Resource\": [\"arn:aws:s3:::" + bucketName + "/*\"]\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder()
                        .bucket(bucketName)
                        .config(publicPolicy)
                        .build());
            }

            // 唯一文件名
            String fileName = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();

            // 上传文件
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(fileName)
                    .stream(inputStream, file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build());

            String url = endpointUrl + "/" + bucketName + "/" + fileName;
            return Result.ok(url);

        } catch (MinioException e) {
            e.printStackTrace();
            return Result.fail("上传异常: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("上传异常: " + e.getMessage());

        }
    }
}