package com.fastlearn.course.infrastructure.rest.controller.dto.request;

import com.fastlearn.course.domain.model.CourseContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    private Long id;
    private String title;
    private String description;
    private String owner;
    private Double price;
}
