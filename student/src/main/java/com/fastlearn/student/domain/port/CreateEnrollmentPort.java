package com.fastlearn.student.domain.port;

import com.fastlearn.student.domain.model.Enrollment;

public interface CreateEnrollmentPort {

    Enrollment createEnrollment(Enrollment enrollment);
}
