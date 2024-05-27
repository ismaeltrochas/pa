package com.fastlearn.student.application.enrollment.service;

import com.fastlearn.student.application.enrollment.mapper.EnrollmentDtoMapper;
import com.fastlearn.student.application.enrollment.usecase.CreateEnrollmentUseCase;
import com.fastlearn.student.domain.model.dto.EnrollmentDTO;
import com.fastlearn.student.domain.port.CreateEnrollmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentManagementService implements CreateEnrollmentUseCase {

    private final CreateEnrollmentPort createEnrollmentPort;
    private final EnrollmentDtoMapper enrollmentDtoMapper;

    @Override
    public EnrollmentDTO createEnrollment(EnrollmentDTO enrollmentDTO) {
        return enrollmentDtoMapper
                .toDto(createEnrollmentPort.createEnrollment(
                        enrollmentDtoMapper.toEntity(enrollmentDTO)));
    }
}
