package com.fastlearn.course.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class FileUploadDTO {

  private String title;
  private String path;
  private byte[] content;
  private Long courseId;

}
