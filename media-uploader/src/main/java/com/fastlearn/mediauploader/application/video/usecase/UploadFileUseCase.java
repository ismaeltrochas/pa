package com.fastlearn.mediauploader.application.video.usecase;

import com.fastlearn.mediauploader.domain.model.dto.FileUploadDTO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileUseCase {

  FileUploadDTO uploadFile(Long id, MultipartFile file);

}
