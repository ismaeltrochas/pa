package com.fastlearn.course.infrastructure.jpa.repository;

import com.fastlearn.course.infrastructure.jpa.entity.CourseContentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseContentRepository extends JpaRepository<CourseContentEntity, Long> {

  List<CourseContentEntity> findByCourseId(Long courseContentId);

}