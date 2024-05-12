package com.fastlearn.mediauploader.domain.port;

import com.fastlearn.mediauploader.domain.model.dto.FileUploadDTO;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadPort {

  FileUploadDTO fileUploadDTO(Long id, MultipartFile file) throws IOException;

}
