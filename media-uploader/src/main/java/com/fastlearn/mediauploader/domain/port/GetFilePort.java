package com.fastlearn.mediauploader.domain.port;

import com.fastlearn.mediauploader.domain.model.dto.FileUploadDTO;
import java.util.List;

public interface GetFilePort {


  List<FileUploadDTO> getObjectById(Long id);

}
