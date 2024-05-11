package com.fastlearn.course.infrastructure.rest.controller.mapper;

import com.fastlearn.course.domain.model.dto.CourseContentDTO;
import com.fastlearn.course.infrastructure.rest.controller.dto.response.CourseContentResponse;
import com.fastlearn.course.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseContentResponseMapper extends
    EntityToDto<CourseContentDTO, CourseContentResponse> {

}
