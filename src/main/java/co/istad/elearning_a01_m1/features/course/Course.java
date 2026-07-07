package co.istad.elearning_a01_m1.features.course;


import co.istad.elearning_a01_m1.config.auditing.BasedEntity;
import co.istad.elearning_a01_m1.features.category.Category;
import co.istad.elearning_a01_m1.features.enrollment.Enrollment;
import co.istad.elearning_a01_m1.features.instructor.InstructorProfile;
import co.istad.elearning_a01_m1.features.video.Video;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course extends BasedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String slug;
    private String keyword;
    private String title;
    private String description;
    private String thumbnail;
    private Float starRating;
    private Integer countRating;
    private Float totalHours;
    private String level;
    private BigDecimal price;
    private Float discountPercent;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;


    @ManyToOne
    private Category category;


    @OneToMany(mappedBy = "course")
    private List<Video> videos;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;


    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private InstructorProfile instructorProfile;

    private Boolean isPublish;
    private Boolean isDeleted;

}
