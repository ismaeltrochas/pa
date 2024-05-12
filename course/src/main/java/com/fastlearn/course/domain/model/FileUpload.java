package com.fastlearn.course.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class FileUpload {


  private Long id;
  private String name;
  private String path;
  private Long courseId;


}
