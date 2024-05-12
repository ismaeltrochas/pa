package com.fastlearn.mediauploader.infrastructure.jpa.adapter;

import com.fastlearn.mediauploader.domain.model.dto.FileUploadDTO;
import com.fastlearn.mediauploader.domain.port.FileUploadPort;
import com.fastlearn.mediauploader.domain.port.S3ManagementPort;
import com.fastlearn.mediauploader.infrastructure.configuration.S3BucketConfig;
import com.fastlearn.mediauploader.infrastructure.jpa.entity.FileUploadEntity;
import com.fastlearn.mediauploader.infrastructure.jpa.repository.FileUploadRepository;
import java.io.IOException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class FileUploadAdapter implements FileUploadPort {

  private final S3BucketConfig s3BucketConfig;
  private final S3ManagementPort s3ManagementPort;
  private final FileUploadRepository fileUploadRepository;

  @Override
  public FileUploadDTO fileUploadDTO(Long id, MultipartFile file) throws IOException {
    return toDTO(fileUploadRepository.save(
        toEntity(new FileUploadDTO(
            file.getOriginalFilename(),
            uploadFile(id, file),
            file.getBytes(),
            id) // TODO
        )
    ));
  }

  private String uploadFile(
      Long courseId,
      MultipartFile file) {
    String path = UUID.randomUUID().toString();
    try {

      s3ManagementPort.putObject(s3BucketConfig.getCustomer(),
          "course-content/%s/%s".formatted(courseId, path),
          file.getBytes());

    } catch (IOException e) {
      throw new IllegalStateException("Failed to upload " + path);
    }
    return path;
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
