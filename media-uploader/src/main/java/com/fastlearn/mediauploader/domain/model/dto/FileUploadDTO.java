package com.fastlearn.mediauploader.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class FileUploadDTO {

  private String title;
  private String path;
  private byte[] content;
  private Long courseId;

}
