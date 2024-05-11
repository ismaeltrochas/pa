package com.fastlearn.course.domain.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

  private Long id;
  private String title;
  private String description;
  private String owner;
  private Double price;
  private List<CourseContent> courseContents;
}
