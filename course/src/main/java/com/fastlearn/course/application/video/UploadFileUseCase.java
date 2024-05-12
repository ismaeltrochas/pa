package com.fastlearn.course.application.video;

import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileUseCase {

  FileUploadDTO uploadFile(Long courseId, MultipartFile file);

}
