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
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime dateOfBirth;
    private LocalDateTime enrollmentDate;

}
