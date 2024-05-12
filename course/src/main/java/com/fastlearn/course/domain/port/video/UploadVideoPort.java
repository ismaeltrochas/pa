package com.fastlearn.course.domain.port.video;

import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadVideoPort {

  FileUploadDTO fileUploadDTO(Long courseId, MultipartFile file);

}
