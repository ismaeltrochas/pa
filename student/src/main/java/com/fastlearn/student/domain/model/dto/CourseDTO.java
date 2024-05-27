package com.fastlearn.student.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CourseDTO {
    private String title;
    private String description;
    private String owner;
    private Double price;
}
