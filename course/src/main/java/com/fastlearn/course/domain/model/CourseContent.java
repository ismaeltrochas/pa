package com.fastlearn.course.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CourseContent {

  private Long id;
  private String name;
  private Course courseId;
  private LocalDateTime createdAt;

}
