package co.istad.elearning_a01_m1.features.student;




import co.istad.elearning_a01_m1.config.auditing.BasedEntity;
import co.istad.elearning_a01_m1.features.enrollment.Enrollment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student_profiles")
public class StudentProfile extends BasedEntity {

    @Id
    private String userId;

    private String university;
    private String major;
    private String biography;
    private String jobTitle;
    private String phoneNumber;
    private String githubLink;
    private String facebookLink;


    @OneToMany(mappedBy = "studentProfile")
    private List<Enrollment> enrollments;


}
