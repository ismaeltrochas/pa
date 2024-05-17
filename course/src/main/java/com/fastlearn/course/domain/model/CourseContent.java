package com.fastlearn.course.domain.model;

import java.time.LocalDateTime;
import java.util.List;

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
  private String title;
  private Course course;
  private LocalDateTime createdAt;

}
