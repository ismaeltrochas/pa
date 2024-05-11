package com.fastlearn.course.infrastructure.jpa.mapper;

import com.fastlearn.course.domain.model.Course;
import com.fastlearn.course.infrastructure.jpa.entity.CourseEntity;
import com.fastlearn.course.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseEntityMapper extends EntityToDto<Course, CourseEntity> {

}
