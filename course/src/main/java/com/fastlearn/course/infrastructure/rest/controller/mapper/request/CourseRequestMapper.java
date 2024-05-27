package com.fastlearn.course.infrastructure.rest.controller.mapper.request;

import com.fastlearn.course.domain.model.dto.CourseDTO;
import com.fastlearn.course.infrastructure.rest.controller.dto.request.CourseRequest;
import com.fastlearn.course.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseRequestMapper extends EntityToDto<CourseDTO, CourseRequest> {
}
