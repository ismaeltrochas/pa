package com.fastlearn.course.application.video;

import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import com.fastlearn.course.domain.port.video.GetVideoPort;
import com.fastlearn.course.domain.port.video.UploadVideoPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class VideoManagementService implements UploadFileUseCase, GetUploadFileUseCase {

  private final UploadVideoPort uploadVideoPort;
  private final GetVideoPort getVideoPort;

  @Override
  public FileUploadDTO uploadFile(Long courseId, MultipartFile file) {
    return uploadVideoPort.fileUploadDTO(courseId, file);
  }

  @Override
  public List<FileUploadDTO> getFileById(Long id) {
    return getVideoPort.getFileById(id);
  }
}
