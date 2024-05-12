package com.fastlearn.course.infrastructure.jpa.adapter.video;

import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import com.fastlearn.course.domain.port.video.UploadVideoPort;
import com.fastlearn.course.infrastructure.configuration.feignclient.VideoFeignClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UploadVideoAdapter implements UploadVideoPort {

  private final VideoFeignClientService videoFeignClientService;

  @Override
  public FileUploadDTO fileUploadDTO(Long courseId, MultipartFile file) {
    return videoFeignClientService.uploadFile(courseId, file);
  }

}
