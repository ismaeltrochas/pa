package com.fastlearn.mediauploader.infrastructure.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Data
@Configuration
public class S3Config {

  @Value("${aws.accessKeyId}")
  private String accessKeyId;
  @Value("${aws.region}")
  private String region;
  @Value("${aws.secretKey}")
  private String secretKey;

  @Bean
  public S3Client s3Client() {

    Region region1 = Region.of(region);
    AwsCredentials awsCredentialsProvider = AwsBasicCredentials.create(accessKeyId, secretKey);

    return S3Client.builder()
        .region(region1)
        .credentialsProvider(StaticCredentialsProvider.create(awsCredentialsProvider))
        .build();
  }
}