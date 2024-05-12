package com.fastlearn.mediauploader.application.video.usecase;

import com.fastlearn.mediauploader.domain.model.dto.FileUploadDTO;
import java.util.List;

public interface GetFileUseCase {
  List<FileUploadDTO> getObjectById(Long id);
}
