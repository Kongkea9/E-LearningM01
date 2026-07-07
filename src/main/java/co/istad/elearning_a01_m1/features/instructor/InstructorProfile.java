package co.istad.elearning_a01_m1.features.instructor;


import co.istad.elearning_a01_m1.config.auditing.BasedEntity;
import co.istad.elearning_a01_m1.features.course.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "instructor_profiles")
public class InstructorProfile extends BasedEntity {

    
    public InstructorProfile(String userId)
    {
        this.userId = userId;
    }

    @Id
    private String userId;


    private String biography;
    private String jobTitle;
    private String phoneNumber;
    private String githubLink;
    private String facebookLink;

    @OneToMany(mappedBy = "instructorProfile")
    private List<Course> courses;


}
