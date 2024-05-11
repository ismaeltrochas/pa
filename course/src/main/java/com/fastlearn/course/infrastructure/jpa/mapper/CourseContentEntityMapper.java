package com.fastlearn.course.infrastructure.jpa.mapper;

import com.fastlearn.course.domain.model.CourseContent;
import com.fastlearn.course.infrastructure.jpa.entity.CourseContentEntity;
import com.fastlearn.course.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseContentEntityMapper extends EntityToDto<CourseContent, CourseContentEntity> {

}
