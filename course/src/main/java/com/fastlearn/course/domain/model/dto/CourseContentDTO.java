package com.fastlearn.course.domain.model.dto;

import com.fastlearn.course.domain.model.CourseContent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseContentDTO {

    private Long id;
    private String title;
    private CourseDTO course;
    private List<CourseContent> videoResponses;
    private LocalDateTime createdAt;
}
