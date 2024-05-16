package com.fastlearn.course.domain.model.dto;

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

    private String title;
    private CourseDTO course;
    private LocalDateTime createdAt;
}
