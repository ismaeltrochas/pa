package com.fastlearn.course.domain.model.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CourseContentDTO {

  private String title;
  private CourseDTO course;
  private LocalDateTime createdAt;
}
