package com.fastlearn.course.application.course.mapper;

import com.fastlearn.course.domain.model.Course;
import com.fastlearn.course.domain.model.dto.CourseDTO;
import com.fastlearn.course.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseDTOMapper extends EntityToDto<Course, CourseDTO> {

}
