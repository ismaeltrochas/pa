package com.fastlearn.student.infrastructure.jpa.entity;

import com.fastlearn.student.domain.model.Enrollment;
import com.fastlearn.student.shared.utils.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EnrollmentEntityMapper extends EntityToDto<Enrollment, EnrollmentEntity> {

    @Mapping(source = "courseId", target = "course.id")
    @Mapping(source = "studentId", target = "student.id")
    Enrollment toEntity(EnrollmentEntity enrollmentEntity);

}
