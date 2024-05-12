package com.fastlearn.mediauploader.application.configuration;

import com.fastlearn.mediauploader.application.video.service.FileUploadManagementService;
import com.fastlearn.mediauploader.domain.port.FileUploadPort;
import com.fastlearn.mediauploader.domain.port.GetFilePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoBeanManagement {

  @Bean
  public FileUploadManagementService fileUploadManagementService(
      FileUploadPort fileUploadPort,
      GetFilePort getFilePort) {
    return new FileUploadManagementService(fileUploadPort, getFilePort);
  }
}
