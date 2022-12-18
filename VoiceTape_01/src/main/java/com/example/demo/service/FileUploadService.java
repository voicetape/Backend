package com.example.demo.service;

import com.example.demo.config.aws.AwsProperty;
import com.example.demo.constant.RecordConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final AwsProperty awsProperty;
    private final S3Presigner s3Presigner;

    public URL getUploadUrl(String username) {

        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(10))
                .putObjectRequest(
                        p -> p.bucket(awsProperty.getS3BucketName())
                                .key(getFileKey())
                                .contentType(RecordConstant.CONTENT_TYPE.getValue())
                                .metadata(getMetadata(username))
                )
                .build();

        return s3Presigner.presignPutObject(presignRequest)
                .url();
    }

    private static String getFileKey() {
        return UUID.randomUUID().toString() + ".mp3";
    }

    private static Map<String, String> getMetadata(String username) {
        return Map.of("username", username);
    }
}
