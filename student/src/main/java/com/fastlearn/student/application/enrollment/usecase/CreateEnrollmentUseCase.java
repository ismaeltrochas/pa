package com.fastlearn.student.application.enrollment.usecase;

import com.fastlearn.student.domain.model.dto.EnrollmentDTO;

public interface CreateEnrollmentUseCase {
    EnrollmentDTO createEnrollment(EnrollmentDTO enrollmentDTO);
}
