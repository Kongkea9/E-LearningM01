package co.istad.elearning_a01_m1.features.course;


import co.istad.elearning_a01_m1.features.course.dto.CourseResponse;
import co.istad.elearning_a01_m1.features.course.dto.CreateCourseRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course mapCreateCourseRequestToCourse(CreateCourseRequest createCourseRequest);

    CourseResponse mapCourseToCourseResponse(Course course);
}



