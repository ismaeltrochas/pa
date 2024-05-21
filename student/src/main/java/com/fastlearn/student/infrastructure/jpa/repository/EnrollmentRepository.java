package com.fastlearn.student.infrastructure.jpa.repository;

import com.fastlearn.student.infrastructure.jpa.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {

    List<EnrollmentEntity> findAllByStudentId(Long id);
}
