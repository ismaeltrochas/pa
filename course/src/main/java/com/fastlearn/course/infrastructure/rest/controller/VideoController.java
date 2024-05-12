package com.fastlearn.course.infrastructure.rest.controller;

import com.fastlearn.course.application.video.VideoManagementService;
import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/file-upload")
@RequiredArgsConstructor
@Slf4j
public class VideoController {

  private final VideoManagementService videoManagementService;

  @PostMapping(path = "/upload-content/{id}")
  public ResponseEntity<FileUploadDTO> uploadFile(
      @PathVariable("id") Long id,
      @RequestPart MultipartFile file) {
    log.info("Uploading file with name: {}", file.getOriginalFilename());
    return new ResponseEntity<>(videoManagementService.uploadFile(id, file),
        HttpStatus.OK);
  }

  @GetMapping(path = "/get/{id}")
  public ResponseEntity<List<FileUploadDTO>> getFileById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(videoManagementService.getFileById(id), HttpStatus.OK);
  }

}
