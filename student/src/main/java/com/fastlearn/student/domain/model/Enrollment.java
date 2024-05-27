package com.fastlearn.student.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Enrollment {

    private Long id;
    private Student student;
    private Course course;
    private LocalDateTime enrolledAt;

}
