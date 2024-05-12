package com.fastlearn.mediauploader.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FileUpload {

  private Long id;
  private String name;
  private String path;
  private Long courseId;


}
