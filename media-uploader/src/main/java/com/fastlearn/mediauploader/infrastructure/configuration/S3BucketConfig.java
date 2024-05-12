package com.fastlearn.mediauploader.infrastructure.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@AllArgsConstructor
@Configuration
@NoArgsConstructor
public class S3BucketConfig {

  @Value("${aws.s3.buckets.customer}")
  private String customer;

}