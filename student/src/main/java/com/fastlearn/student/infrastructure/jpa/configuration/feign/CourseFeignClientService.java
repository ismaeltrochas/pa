package com.fastlearn.student.infrastructure.jpa.configuration.feign;


import com.fastlearn.student.domain.model.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fl-mcsv-course", url = "http://localhost:8082/api/course")
public interface CourseFeignClientService {

    @GetMapping("/find/{id}")
    CourseDTO findAllCourseById(@PathVariable("id") Long id);
}
