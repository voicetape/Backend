package com.example.demo.config.aws;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import software.amazon.awssdk.regions.Region;

@Getter
@Configuration
@PropertySource("classpath:aws.properties")
public class AwsProperty {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private Region region;

    @Value("${cloud.aws.s3.bucket}")
    private String s3BucketName;

}
