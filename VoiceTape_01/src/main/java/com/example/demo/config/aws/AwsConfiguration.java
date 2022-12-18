package com.example.demo.config.aws;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
@RequiredArgsConstructor
public class AwsConfiguration {

    private final AwsProperty awsProperty;

    @Bean
    public ProfileCredentialsProvider profileCredentialsProvider() {
        return ProfileCredentialsProvider.create();
    }

    @Bean
    public S3Client amazonS3Client() {
        return S3Client.builder()
                .region(awsProperty.getRegion())
                .credentialsProvider(profileCredentialsProvider())
                .build();
    }

    @Bean
    public S3Presigner s3Presigner() {
        return S3Presigner.builder()
                .region(awsProperty.getRegion())
                .credentialsProvider(profileCredentialsProvider())
                .build();
    }

}
