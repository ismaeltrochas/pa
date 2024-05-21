package com.fastlearn.student.infrastructure.jpa.adapter;

import com.fastlearn.student.domain.model.dto.CourseDTO;
import com.fastlearn.student.infrastructure.jpa.configuration.feign.CourseFeignClientService;
import com.fastlearn.student.infrastructure.jpa.entity.EnrollmentEntity;
import com.fastlearn.student.infrastructure.jpa.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllCourseByStudentIdAdapter {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseFeignClientService courseFeignClientService;

    public List<CourseDTO> findAllByStudentId(Long id) {
        List<EnrollmentEntity> entities = enrollmentRepository.findAllByStudentId(id);
        return entities
                .stream()
                .map(obj -> courseFeignClientService.findAllCourseById(obj.getCourseId()))
                .collect(Collectors.toList());

    }

}
