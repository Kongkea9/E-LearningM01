package co.istad.elearning_a01_m1.features.course;

import co.istad.elearning_a01_m1.features.course.dto.CourseResponse;
import co.istad.elearning_a01_m1.features.course.dto.CreateCourseRequest;

public interface CourseService {

    CourseResponse createCourse(CreateCourseRequest createCourseRequest);

}
