package co.istad.elearning_a01_m1.features.category;


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
@Table(name = "categories")
public class Category extends BasedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false , unique = true)
    private String name;
    private String icon;

    @Column(nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "category")
    private List<Course> courses;


}
