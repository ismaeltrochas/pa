package com.fastlearn.student.domain.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class EnrollmentDTO {

    private StudentDTO student;
    private CourseDTO course;
    private LocalDateTime enrolledAt;


}
