package com.fastlearn.mediauploader.infrastructure.jpa.adapter;

import com.fastlearn.mediauploader.domain.port.S3ManagementPort;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;


@Service
@AllArgsConstructor
@Slf4j
public class S3ServiceAdapter implements S3ManagementPort {

  private final S3Client s3Client;

  @Override
  public void putObject(String bucketName, String key, byte[] file) {
    PutObjectRequest request = PutObjectRequest.builder()
        .bucket(bucketName)
        .key(key)
        .build();
    s3Client.putObject(request, RequestBody.fromBytes(file));
  }

  @Override
  public byte[] getObject(String bucketName, String key) {
    GetObjectRequest getRequest = GetObjectRequest.builder().bucket(bucketName).key(key).build();
    ResponseInputStream<GetObjectResponse> res = s3Client.getObject(getRequest);

    try {
      return res.readAllBytes();
    } catch (IOException e) {
      log.error("Failed to read file bytes: {}", e.getMessage());
      throw new RuntimeException("Error: {}", e.getCause());
    }
  }
}
