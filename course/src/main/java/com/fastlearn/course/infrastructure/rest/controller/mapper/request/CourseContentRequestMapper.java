package com.fastlearn.course.infrastructure.rest.controller.mapper.request;

import com.fastlearn.course.domain.model.dto.CourseContentDTO;
import com.fastlearn.course.infrastructure.rest.controller.dto.request.CourseContentRequest;
import com.fastlearn.course.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        CourseRequestMapper.class
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CourseContentRequestMapper extends EntityToDto<CourseContentDTO, CourseContentRequest> {

    @Mapping(source = "courseId", target = "course.id")
    @Mapping(source = "title", target = "title")
    CourseContentDTO toEntity(CourseContentRequest courseContentRequest);
}
