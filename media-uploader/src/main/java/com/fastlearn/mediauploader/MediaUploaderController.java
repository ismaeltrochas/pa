package com.fastlearn.mediauploader;

import com.fastlearn.mediauploader.service.MediaUploaderService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
public class MediaUploaderController {

  private final MediaUploaderService mediaUploaderService;

  @PostMapping("/upload/{option}/{courseId}")
  public ResponseEntity<String> uploadThumbnail(
      @PathVariable("option") String option,
      @PathVariable("courseId") Long courseId,
      @RequestPart("file") MultipartFile file
  ) throws IOException {
    return ResponseEntity.ok(mediaUploaderService.createFile(courseId, file, option));
  }

  @GetMapping("/retrieve/{courseId}")
  public ResponseEntity<Resource> showImage(@PathVariable Long courseId)
      throws IOException {

    Resource resource = mediaUploaderService.loadImage(courseId);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_JPEG);

    return ResponseEntity.ok()
        .headers(headers)
        .body(resource);
  }

  @GetMapping(path = "/findAllByCourseId/{courseId}")
  public List<String> getAllImagesId(@PathVariable Long courseId) {
    return mediaUploaderService.getImageId(courseId);
  }

/*  @GetMapping("/download/{fileName:.+}")
  public ResponseEntity<Resource> downloadFile(@PathVariable String fileName)
      throws MalformedURLException {
    Path filePath = Paths.get(storageLocation).resolve(fileName);
    Resource resource = new UrlResource(filePath.toUri());
    return ResponseEntity.ok()
        .body(resource);
  }
*/
}
