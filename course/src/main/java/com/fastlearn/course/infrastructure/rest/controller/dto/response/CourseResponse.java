package com.fastlearn.course.infrastructure.rest.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CourseResponse {

    private String id;
    private String title;
    private String description;
    private String owner;
    private Double price;
    private List<CourseContentResponse> courseContent;

}
