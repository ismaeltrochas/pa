package com.fastlearn.course.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StatusDTO {

    private Long id;
    private String name;
    private String description;

}
