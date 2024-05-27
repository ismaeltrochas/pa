package com.fastlearn.student.application.enrollment.mapper;


import com.fastlearn.student.domain.model.Enrollment;
import com.fastlearn.student.domain.model.dto.EnrollmentDTO;
import com.fastlearn.student.shared.utils.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EnrollmentDtoMapper extends EntityToDto<Enrollment, EnrollmentDTO> {
}
