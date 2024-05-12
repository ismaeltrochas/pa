package com.fastlearn.mediauploader.domain.port;

public interface S3ManagementPort {


  void putObject(String bucketName, String key, byte[] file);

  byte[] getObject(String bucketName, String key);


}