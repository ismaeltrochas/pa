package com.fastlearn.course.infrastructure.jpa.adapter.coursecontent;

import com.fastlearn.course.domain.model.CourseContent;
import com.fastlearn.course.domain.port.coursecontent.FindCourseContentPort;
import com.fastlearn.course.infrastructure.jpa.mapper.CourseContentEntityMapper;
import com.fastlearn.course.infrastructure.jpa.repository.CourseContentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCourseContentAdapter implements FindCourseContentPort {

  private final CourseContentRepository courseContentRepository;
  private final CourseContentEntityMapper courseContentEntityMapper;

  public List<CourseContent> courseContentEntities(Long id) {
    return courseContentEntityMapper.toEntity(
        courseContentRepository.findByCourseId(id));
  }
}
