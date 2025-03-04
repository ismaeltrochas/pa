package com.fastlearn.mediauploader.infrastructure.rest;

import com.fastlearn.mediauploader.application.video.service.FileUploadManagementService;
import com.fastlearn.mediauploader.domain.model.dto.FileUploadDTO;
import com.fastlearn.mediauploader.infrastructure.jpa.adapter.GetFileUploadAdapter;
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
public class FileUploadController {

    private final FileUploadManagementService fileUploadManagementService;
    private final GetFileUploadAdapter getFileUploadAdapter;


    @PostMapping(path = "/upload-content/{id}")
    public ResponseEntity<List<FileUploadDTO>> uploadFile(
            @PathVariable("id") Long id,
            @RequestPart MultipartFile[] file) {
        return new ResponseEntity<>(Arrays.stream(file)
                .map(files -> fileUploadManagementService.uploadFile(id, files))
                .collect(Collectors.toList()),
                HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<List<FileUploadDTO>> getFileById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(getFileUploadAdapter.getObjectById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/get/greetings")
    public String greetings() {
        return "Hello world!";
    }


}
