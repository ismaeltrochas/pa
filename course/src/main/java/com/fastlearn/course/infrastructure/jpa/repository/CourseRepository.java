package com.fastlearn.course.infrastructure.jpa.repository;

import com.fastlearn.course.infrastructure.jpa.entity.CourseEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

  List<CourseEntity> findAllByOwner(String owner);
  @Query("SELECT c FROM CourseEntity c WHERE c.price BETWEEN :minPrice AND :maxPrice")
  List<CourseEntity> findAllByPrice(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);


}
