package com.fastlearn.course.application.video;

import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadFileUseCase {

  List<FileUploadDTO> uploadFile(Long courseId, MultipartFile file);

}
