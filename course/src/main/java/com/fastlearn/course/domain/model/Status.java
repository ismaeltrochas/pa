package com.fastlearn.course.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Status {

    private Long id;
    private String name;
    private String description;

}
