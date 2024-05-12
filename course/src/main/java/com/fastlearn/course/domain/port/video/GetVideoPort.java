package com.fastlearn.course.domain.port.video;

import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import java.util.List;

public interface GetVideoPort{
  List<FileUploadDTO> getFileById(Long id);
}
