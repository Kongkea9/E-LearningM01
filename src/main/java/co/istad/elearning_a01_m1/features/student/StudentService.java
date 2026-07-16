package co.istad.elearning_a01_m1.features.student;

import co.istad.elearning_a01_m1.features.student.dto.StudentProfileResponse;
import co.istad.elearning_a01_m1.features.student.dto.UpdateStudentProfileRequest;

public interface StudentService {

    StudentProfileResponse me();
    StudentProfileResponse updateProfile(UpdateStudentProfileRequest updateStudentProfileRequest);
}
