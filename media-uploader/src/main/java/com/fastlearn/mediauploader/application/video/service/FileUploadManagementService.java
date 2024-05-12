package com.fastlearn.mediauploader.application.video.service;

import com.fastlearn.mediauploader.application.video.usecase.GetFileUseCase;
import com.fastlearn.mediauploader.application.video.usecase.UploadFileUseCase;
import com.fastlearn.mediauploader.domain.model.dto.FileUploadDTO;
import com.fastlearn.mediauploader.domain.port.FileUploadPort;
import com.fastlearn.mediauploader.domain.port.GetFilePort;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
public class FileUploadManagementService implements UploadFileUseCase, GetFileUseCase {

  private final FileUploadPort fileUploadPort;
  private final GetFilePort getFilePort;

  @Override
  public FileUploadDTO uploadFile(Long id, MultipartFile file) {
    try {
      return fileUploadPort.fileUploadDTO(id, file);
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }


  @Override
  public List<FileUploadDTO> getObjectById(Long id) {
    return getFilePort.getObjectById(id);
  }
}
