package com.fastlearn.course.application.coursecontent.service;

import com.fastlearn.course.application.course.service.CourseManagementService;
import com.fastlearn.course.application.coursecontent.mapper.CourseContentDTOMapper;
import com.fastlearn.course.application.coursecontent.usecase.CreateCourseContentUseCase;
import com.fastlearn.course.application.coursecontent.usecase.FindCourseContentUseCase;
import com.fastlearn.course.domain.model.dto.CourseContentDTO;
import com.fastlearn.course.domain.model.dto.CourseDTO;
import com.fastlearn.course.domain.port.coursecontent.CreateCourseContentPort;
import com.fastlearn.course.domain.port.coursecontent.FindCourseContentPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CourseContentManagementService implements CreateCourseContentUseCase,
        FindCourseContentUseCase {

    private final CreateCourseContentPort createCourseContentPort;
    private final FindCourseContentPort findCourseContentPort;
    private final CourseContentDTOMapper courseContentDTOMapper;
    private final CourseManagementService courseManagementService;

    @Override
    public CourseContentDTO createCourseContent(CourseContentDTO courseContentDTO) {
        CourseContentDTO courseContentDTO1 = courseContentDTOMapper.toDto(createCourseContentPort.createCourseContent(
                courseContentDTOMapper.toEntity(courseContentDTO)));
        CourseDTO course = courseManagementService.findById(courseContentDTO1.getCourse().getId());
        courseContentDTO1.setCourse(course);
        return courseContentDTO1;
    }


    @Override
    public List<CourseContentDTO> courseContentEntities(Long id) {
        return courseContentDTOMapper.toDto(findCourseContentPort.courseContentEntities(id));
    }
}
