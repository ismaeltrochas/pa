package com.fastlearn.course.infrastructure.rest.controller.dto.response;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CourseResponse {

    private Long id;
    private String title;
    private String description;
    private String owner;
    private Double price;
    private List<CourseContentResponse> courseContent;

}
