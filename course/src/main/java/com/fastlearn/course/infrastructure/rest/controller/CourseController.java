package com.fastlearn.course.infrastructure.rest.controller;

import com.fastlearn.course.application.course.service.CourseManagementService;
import com.fastlearn.course.domain.model.dto.CourseDTO;
import com.fastlearn.course.infrastructure.rest.controller.dto.response.CourseResponse;
import com.fastlearn.course.infrastructure.rest.controller.mapper.response.CourseResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/course")
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseManagementService courseManagementService;
    private final CourseResponseMapper courseResponseMapper;

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<CourseResponse> findAllCourseById(@PathVariable Long id) {
        return new ResponseEntity<>(courseResponseMapper.toDto(courseManagementService.findById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "/findAllByOwnerName")
    public ResponseEntity<List<CourseDTO>> findAllByOwner(
            @RequestParam("ownerName") String ownerName) {
        return new ResponseEntity<>(courseManagementService.findAllByOwner(ownerName), HttpStatus.OK);
    }

    @GetMapping(path = "/findAllByPrice")
    public ResponseEntity<List<CourseDTO>> findAllByPriceIn(Double minPrice, Double maxPrice) {
        return new ResponseEntity<>(courseManagementService.findByPriceIn(minPrice, maxPrice),
                HttpStatus.OK);
    }


}
