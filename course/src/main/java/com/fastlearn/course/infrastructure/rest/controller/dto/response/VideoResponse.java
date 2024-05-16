package com.fastlearn.course.infrastructure.rest.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoResponse {

  private String id;
  private String title;
  private String code;
  private byte[] content;

}
