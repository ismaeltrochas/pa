package com.fastlearn.course.infrastructure.rest.controller;


import com.fastlearn.course.application.coursecontent.service.CourseContentManagementService;
import com.fastlearn.course.domain.model.dto.CourseContentDTO;
import com.fastlearn.course.infrastructure.rest.controller.dto.request.CourseContentRequest;
import com.fastlearn.course.infrastructure.rest.controller.dto.response.CourseContentResponse;
import com.fastlearn.course.infrastructure.rest.controller.mapper.request.CourseContentRequestMapper;
import com.fastlearn.course.infrastructure.rest.controller.mapper.response.CourseContentResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/course-content")
@RequiredArgsConstructor
public class CourseContentController {

    private final CourseContentManagementService courseContentManagementService;
    private final CourseContentResponseMapper courseContentResponseMapper;
    private final CourseContentRequestMapper courseContentRequestMapper;

    @PostMapping
    public ResponseEntity<CourseContentDTO> createCourseContent(@RequestBody CourseContentRequest courseContentRequest) {
        return new ResponseEntity<>(courseContentManagementService.createCourseContent(
                courseContentRequestMapper.toEntity(courseContentRequest)), HttpStatus.CREATED);
    }


    @GetMapping(path = "/findByCourse")
    public ResponseEntity<List<CourseContentResponse>> findAllCourseContentByCourseId(
            @RequestParam("courseId") Long courseId) {
        return new ResponseEntity<>(courseContentResponseMapper.toDto(
                courseContentManagementService.courseContentEntities(courseId)),
                HttpStatus.OK);

    }


}
