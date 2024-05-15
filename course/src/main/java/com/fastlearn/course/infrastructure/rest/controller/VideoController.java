package com.fastlearn.course.infrastructure.rest.controller;

import com.fastlearn.course.application.video.VideoManagementService;
import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/file-upload")
@RequiredArgsConstructor
@Slf4j
public class VideoController {

    private final VideoManagementService videoManagementService;

    @PostMapping(path = "/upload-content/{id}")
    public ResponseEntity<List<FileUploadDTO>> uploadFile(
            @PathVariable("id") Long id,
            @RequestPart MultipartFile[] file) {

        return new ResponseEntity<>(Arrays.stream(file)
                .flatMap(files -> videoManagementService.uploadFile(id, files).stream())
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<List<FileUploadDTO>> getFileById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(videoManagementService.getFileById(id), HttpStatus.OK);
    }

}
