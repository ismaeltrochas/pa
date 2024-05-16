package com.fastlearn.course.infrastructure.rest.controller.dto.response;

import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseContentResponse {

  private Long id;
  private String title;
  private List<VideoResponse> videoResponses;

}
