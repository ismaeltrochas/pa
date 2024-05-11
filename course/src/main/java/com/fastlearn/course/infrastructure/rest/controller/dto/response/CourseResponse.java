package com.fastlearn.course.infrastructure.rest.controller.dto.response;

import java.util.List;

public class CourseResponse {
  private String id;
  private String title;
  private String description;
  private String owner;
  private Double price;
  private List<CourseContentResponse> courseContent;
}
