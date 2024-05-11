package com.fastlearn.course.infrastructure.rest.controller;


import com.fastlearn.course.application.coursecontent.service.CourseContentManagementService;
import com.fastlearn.course.infrastructure.rest.controller.dto.response.CourseContentResponse;
import com.fastlearn.course.infrastructure.rest.controller.mapper.CourseContentResponseMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/coursecontent")
@RequiredArgsConstructor
public class CourseContentController {

  private final CourseContentManagementService courseContentManagementService;
  private final CourseContentResponseMapper courseContentResponseMapper;


  @GetMapping(path = "/findByCourse")
  public ResponseEntity<List<CourseContentResponse>> findAllCourseContentByCourseId(
      @RequestParam("courseId") Long courseId) {
    return new ResponseEntity<>(courseContentResponseMapper.toDto(
        courseContentManagementService.courseContentEntities(courseId)),
        HttpStatus.OK);

  }


}
