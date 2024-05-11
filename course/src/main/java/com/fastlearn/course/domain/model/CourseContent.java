package com.fastlearn.course.domain.model;

import com.fastlearn.course.domain.model.Course;
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
  private String name;
  private Course courseId;
  private List<Video> videos;
  private LocalDateTime createdAt;

}
