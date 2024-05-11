package com.fastlearn.course.application.coursecontent.mapper;

import com.fastlearn.course.domain.model.CourseContent;
import com.fastlearn.course.domain.model.dto.CourseContentDTO;
import com.fastlearn.course.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseContentDTOMapper extends EntityToDto<CourseContent, CourseContentDTO> {

}
