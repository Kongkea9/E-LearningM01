package co.istad.elearning_a01_m1.features.video;


import co.istad.elearning_a01_m1.config.auditing.BasedEntity;
import co.istad.elearning_a01_m1.features.command.Comment;
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
@Table(name = "videos")
public class Video extends BasedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String slug;
    private String title;
    private String thumbnail;
    private String duration;
    private String youtube;

    private Boolean isPublished;
    private Boolean isDeleted;


    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "video")
    private List<Comment> comments;


}
