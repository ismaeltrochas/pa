package com.fastlearn.course.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

  private Long id;
  private String title;
  private String description;
  private String owner;
  private Double price;
}
