package com.fastlearn.course.infrastructure.rest.controller.mapper.response;

import com.fastlearn.course.domain.model.dto.CourseDTO;
import com.fastlearn.course.infrastructure.rest.controller.dto.response.CourseResponse;
import com.fastlearn.course.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseResponseMapper extends EntityToDto<CourseDTO, CourseResponse> {
}
