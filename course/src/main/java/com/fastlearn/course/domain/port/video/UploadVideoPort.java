package com.fastlearn.course.domain.port.video;

import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadVideoPort {

  List<FileUploadDTO> fileUploadDTO(Long courseId, MultipartFile file);

}
