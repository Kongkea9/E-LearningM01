package co.istad.elearning_a01_m1.features.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {


      boolean existsBySlug(String slug);


      //Use named query

      List<Course> allCourses();

      Course byId(Integer id);




}
