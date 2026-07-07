package co.istad.elearning_a01_m1.features.course.dto;

import co.istad.elearning_a01_m1.features.category.cateogryDto.CategoryResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CourseResponse(
         Integer id,
         String slug,
         String keyword,
         String title,
         String description,
         String thumbnail,
         Float starRating,
         Integer countRating,
         Float totalHours,
         String level,
         BigDecimal price,
         Float discountPercent,
         LocalDateTime createdAt,
         LocalDateTime updatedAt,
         CategoryResponse category,
         String instructorName,
         Boolean isPublish
) {
}
