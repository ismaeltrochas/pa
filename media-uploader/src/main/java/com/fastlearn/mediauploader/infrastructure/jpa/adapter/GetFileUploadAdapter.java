package com.fastlearn.mediauploader.infrastructure.jpa.adapter;

import com.fastlearn.mediauploader.domain.model.dto.FileUploadDTO;
import com.fastlearn.mediauploader.domain.port.GetFilePort;
import com.fastlearn.mediauploader.domain.port.S3ManagementPort;
import com.fastlearn.mediauploader.infrastructure.configuration.S3BucketConfig;
import com.fastlearn.mediauploader.infrastructure.jpa.entity.FileUploadEntity;
import com.fastlearn.mediauploader.infrastructure.jpa.repository.FileUploadRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetFileUploadAdapter implements GetFilePort {

  private final S3BucketConfig s3BucketConfig;
  private final S3ManagementPort s3ManagementPort;
  private final FileUploadRepository fileUploadRepository;


  @Override
  public List<FileUploadDTO> getObjectById(Long id) {
    return fileUploadRepository.findAllByCourseId(id).stream()
        .map(this::toDTO)
        .peek(file -> file.setContent(getAllObjectsByCourseId(file.getCourseId(), file.getPath())))
        .toList();
  }

  public byte[] getAllObjectsByCourseId(Long courseContentId, String key) {
    // Formar la clave completa para recuperar todos los objetos de S3 en una sola llamada
    log.info("CURRENT KEY: {}", key);
    String s3Key = "course-content/%s/%s".formatted(courseContentId, key);
    return s3ManagementPort.getObject(s3BucketConfig.getCustomer(), s3Key);
  }

  private FileUploadEntity toEntity(FileUploadDTO fileUploadDTO) {
    return FileUploadEntity.builder()
        .title(fileUploadDTO.getTitle())
        .courseId(fileUploadDTO.getCourseId())
        .path(fileUploadDTO.getPath())
        .build();
  }

  private FileUploadDTO toDTO(FileUploadEntity fileUploadEntity) {
    return FileUploadDTO.builder()
        .title(fileUploadEntity.getTitle())
        .courseId(fileUploadEntity.getCourseId())
        .path(fileUploadEntity.getPath())
        .build();
  }
}
