package com.fastlearn.course.domain.port.course;

import com.fastlearn.course.domain.model.Course;
import java.util.List;

public interface GetCoursePort {


  Course findById(Long id);

  List<Course> findAllByOwner(String owner);

  List<Course> findByPriceIn(Double minPrice, Double maxPrice);

  List<Course> findAll();

}
