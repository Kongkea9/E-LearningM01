package co.istad.elearning_a01_m1.features.course;


import co.istad.elearning_a01_m1.features.course.dto.CourseResponse;
import co.istad.elearning_a01_m1.features.course.dto.CreateCourseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CourseResponse createCourse(
            @Valid
            @RequestBody CreateCourseRequest createCourseRequest
            ){
        
        return courseService.createCourse(createCourseRequest);
    }

}
