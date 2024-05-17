package com.fastlearn.course.infrastructure.rest.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseContentRequest {

    private String title;
    private Long courseId;
    private LocalDateTime createdAt;

}
