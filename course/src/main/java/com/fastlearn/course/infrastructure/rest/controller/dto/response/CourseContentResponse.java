package com.fastlearn.course.infrastructure.rest.controller.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseContentResponse {

  private String id;
  private String name;
  private List<VideoResponse> videoResponses;

}
