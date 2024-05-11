package com.fastlearn.course.infrastructure.rest.controller;

import com.fastlearn.course.application.course.service.CourseManagementService;
import com.fastlearn.course.domain.model.dto.CourseDTO;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/course")
@RestController
@RequiredArgsConstructor
public class CourseController {

  private final CourseManagementService courseManagementService;

  @GetMapping(path = "/findAll")
  public ResponseEntity<List<CourseDTO>> findAllCourse() {
    return new ResponseEntity<>(courseManagementService.findAll(), HttpStatus.OK);
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
