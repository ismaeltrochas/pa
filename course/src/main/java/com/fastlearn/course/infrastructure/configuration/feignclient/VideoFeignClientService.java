package com.fastlearn.course.infrastructure.configuration.feignclient;

import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "fl-mcsv-media", url = "http://localhost:8082/api/file-upload/")
public interface VideoFeignClientService {

  @PostMapping(
      path = "/upload-content/{id}",
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )
  List<FileUploadDTO> uploadFile(
      @PathVariable("id") Long courseContentId,
      @RequestPart MultipartFile file);

  @GetMapping(path = "/get/{id}")
  List<FileUploadDTO> getFileById(@PathVariable("id") Long id);
}
