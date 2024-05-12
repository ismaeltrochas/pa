package com.fastlearn.course.application.video;

import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import java.util.List;

public interface GetUploadFileUseCase {

  List<FileUploadDTO> getFileById(Long id);
}
