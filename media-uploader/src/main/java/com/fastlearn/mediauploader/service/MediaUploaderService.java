package com.fastlearn.mediauploader.service;

import com.fastlearn.mediauploader.FileUpload;
import com.fastlearn.mediauploader.MediaUploaderRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class MediaUploaderService {

  private final MediaUploaderRepository mediaUploaderRepository;

  public String createFile(Long id, MultipartFile file, String option) throws IOException {

    File folder = new File("src/main/resources/course/" + id + "/" + option);
    validateIfFileExists(folder);
    validateImageSize(file);
    String fileName = file.getOriginalFilename();
    Path filePath = Paths.get(folder.getPath() + "/" + fileName.concat(".jpg"));
    Files.write(filePath, file.getBytes());
    mediaUploaderRepository.save(
        new FileUpload(UUID.randomUUID().toString(), fileName, folder.getPath() + "/" + fileName,
            id));
    return fileName;
  }

  public List<String> getImageId(Long courseId) {
    return mediaUploaderRepository.findAllByCourseId(courseId).stream()
        .map(FileUpload::getId).collect(
            Collectors.toList());
  }


  public Resource loadImage(Long id) throws IOException {
    FileUpload filePath = mediaUploaderRepository.findByCourseId(id);
    Path path = Paths.get(filePath.getPath());
    Resource resource = new UrlResource(path.toUri());

    if (resource.exists() && resource.isReadable()) {
      return resource;
    } else {
      throw new RuntimeException("Failed to load image: " + filePath.getName());
    }
  }

  private void validateIfFileExists(File file) {
    if (!file.exists()) {
      file.mkdirs();
    }
  }

  private void uploadImage() {

  }

  private void validateImageSize(MultipartFile file) {
    if (file.getSize() > 5 * 1024 * 1024) {
      throw new RuntimeException("Image size must be less than 5MB");
    }
  }

}
