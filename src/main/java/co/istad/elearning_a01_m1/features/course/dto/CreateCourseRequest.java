package co.istad.elearning_a01_m1.features.course.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreateCourseRequest(


        @NotBlank
        @Size(max = 255)
        String slug,

        @NotBlank
        @Size(max = 255)
        String keyword,

        @NotBlank
        @Size(max = 255)
        String title,

        @NotBlank
        @Size(max = 255)
        String description,


        @NotBlank
        @Size(max = 255)
        String thumbnail,

        @Positive
        @NotNull
        @Max(50)
        Float totalHours,

        @NotBlank
        @Size(max = 50)
        String level,

        @Positive
        @NotNull
        BigDecimal price,

        @PositiveOrZero
        @NotNull
        Float discountPercent,

        @Positive
        @NotNull
        Integer categoryId,


        String instructorId

) {



}
