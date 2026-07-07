package co.istad.elearning_a01_m1.features.course;

import co.istad.elearning_a01_m1.features.category.Category;
import co.istad.elearning_a01_m1.features.category.CategoryRepository;
import co.istad.elearning_a01_m1.features.category.exception.CategoryNotFoundException;
import co.istad.elearning_a01_m1.features.course.dto.CourseResponse;
import co.istad.elearning_a01_m1.features.course.dto.CreateCourseRequest;
import co.istad.elearning_a01_m1.features.instructor.InstructorProfile;
import co.istad.elearning_a01_m1.security.AuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements  CourseService{

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponse createCourse(CreateCourseRequest createCourseRequest) {

        // TODO: write your logic

        // validate the slug

        if(courseRepository.existsBySlug(createCourseRequest.slug())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Slug already exists");
        }


        // validate the category

        Category category = categoryRepository.findById(createCourseRequest.categoryId()).orElseThrow(
                () -> new CategoryNotFoundException(createCourseRequest.categoryId())
        );

        // Transfer data from dto to domain
        Course course = courseMapper.mapCreateCourseRequestToCourse(createCourseRequest);

        course.setCategory(category);
        course.setCountRating(0);
        course.setStarRating(0f);
        course.setIsDeleted(false);
        course.setIsPublish(false);

        course.setInstructorProfile(new InstructorProfile(AuthUtils.extractUserId()));



        course = courseRepository.save(course);



        return courseMapper.mapCourseToCourseResponse(course);
    }
}
