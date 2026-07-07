package co.istad.elearning_a01_m1;

import co.istad.elearning_a01_m1.features.course.Course;
import co.istad.elearning_a01_m1.features.course.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableConfigurationProperties
@EnableJpaAuditing
@SpringBootApplication
@Slf4j
public class ElearningA01M1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ElearningA01M1Application.class, args);
	}

	private CourseRepository courseRepository;

	@Autowired
	public void setCourseRepository(CourseRepository courseRepository)
	{
		this.courseRepository = courseRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		List<Course> courses = courseRepository.allCourses();

		Course course = courseRepository.byId(1);

		System.out.println("find course by id: " + course.getTitle());

		for(Course c : courses)
		{
			System.out.println(c.getTitle());
		}
	}
}
