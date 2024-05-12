package com.fastlearn.course.infrastructure.jpa.adapter.video;

import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import com.fastlearn.course.domain.port.video.GetVideoPort;
import com.fastlearn.course.infrastructure.configuration.feignclient.VideoFeignClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetVideoAdapter implements GetVideoPort {

  private final VideoFeignClientService videoFeignClientService;

  @Override
  public List<FileUploadDTO> getFileById(Long id) {
    return videoFeignClientService.getFileById(id);
  }
}
