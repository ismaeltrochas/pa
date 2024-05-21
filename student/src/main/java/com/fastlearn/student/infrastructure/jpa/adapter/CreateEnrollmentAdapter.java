package com.fastlearn.student.infrastructure.jpa.adapter;

import com.fastlearn.student.domain.model.Enrollment;
import com.fastlearn.student.domain.port.CreateEnrollmentPort;
import com.fastlearn.student.infrastructure.jpa.entity.EnrollmentEntityMapper;
import com.fastlearn.student.infrastructure.jpa.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEnrollmentAdapter implements CreateEnrollmentPort {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentEntityMapper enrollmentEntityMapper;

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentEntityMapper
                .toEntity(enrollmentRepository.save(
                        enrollmentEntityMapper.toDto(enrollment)));
    }
}
