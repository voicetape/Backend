package com.example.demo.config.aws;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
@RequiredArgsConstructor
public class AwsConfiguration {

    private final AwsProperty awsProperty;

    @Bean
    public AwsCredentialsProvider awsCredentialsProvider() {
        return StaticCredentialsProvider.create(
                AwsBasicCredentials.create(
                        awsProperty.getAccessKey(),
                        awsProperty.getSecretKey()
                )
        );
    }

    @Bean
    public S3Client amazonS3Client() {
        return S3Client.builder()
                .region(awsProperty.getRegion())
                .credentialsProvider(awsCredentialsProvider())
                .build();
    }

    @Bean
    public S3Presigner s3Presigner() {
        return S3Presigner.builder()
                .region(awsProperty.getRegion())
                .credentialsProvider(awsCredentialsProvider())
                .build();
    }

}
