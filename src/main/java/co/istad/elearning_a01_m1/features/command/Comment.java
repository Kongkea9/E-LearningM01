package co.istad.elearning_a01_m1.features.command;


import co.istad.elearning_a01_m1.config.auditing.BasedEntity;
import co.istad.elearning_a01_m1.features.video.Video;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends BasedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String text;
    private Boolean isDeleted;
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parentComment;

    @ManyToOne
    private Video video;

}
