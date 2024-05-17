package com.fastlearn.course.infrastructure.rest.controller;


import com.fastlearn.course.application.coursecontent.service.CourseContentManagementService;
import com.fastlearn.course.domain.model.dto.CourseContentDTO;
import com.fastlearn.course.infrastructure.configuration.feignclient.VideoFeignClientService;
import com.fastlearn.course.infrastructure.rest.controller.dto.request.CourseContentRequest;
import com.fastlearn.course.infrastructure.rest.controller.dto.response.CourseContentResponse;
import com.fastlearn.course.infrastructure.rest.controller.dto.response.VideoResponse;
import com.fastlearn.course.infrastructure.rest.controller.mapper.request.CourseContentRequestMapper;
import com.fastlearn.course.infrastructure.rest.controller.mapper.response.CourseContentResponseMapper;
import com.fastlearn.course.infrastructure.rest.controller.mapper.response.VideoResponseDTOMapper;
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
    private final VideoFeignClientService videoManagementService;
    private final VideoResponseDTOMapper videoResponseDTOMapper;

    @PostMapping
    public ResponseEntity<CourseContentDTO> createCourseContent(@RequestBody CourseContentRequest courseContentRequest) {
        CourseContentDTO courseContentDTO = courseContentManagementService.createCourseContent(
                courseContentRequestMapper.toEntity(courseContentRequest));
        courseContentDTO.setTitle(courseContentRequest.getTitle());
        return new ResponseEntity<>(courseContentDTO, HttpStatus.CREATED);
    }


    @GetMapping(path = "/findByCourse/{courseId}")
    public ResponseEntity<List<CourseContentResponse>> findAllCourseContentByCourseId(@PathVariable("courseId") Long courseId) {
        List<CourseContentResponse> findAllCourseContentByCourseId = courseContentResponseMapper.toDto(courseContentManagementService.courseContentEntities(courseId));

        for (CourseContentResponse courseContentResponse : findAllCourseContentByCourseId) {
            // Obtener la lista de videos para el contenido del curso actual
            List<VideoResponse> videoResponses = videoResponseDTOMapper.toDto(
                    videoManagementService.getFileById(courseContentResponse.getId())
            );

            // Asignar la lista de videos al CourseContentResponse
            courseContentResponse.setVideoResponses(videoResponses);
        }
        return new ResponseEntity<>(findAllCourseContentByCourseId, HttpStatus.OK);

    }


}
