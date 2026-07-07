package co.istad.elearning_a01_m1.features.category.cateogryDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record CreateCategoryRequest(
        @NotBlank(message = "Name is required")
        @Column(unique = true)
        String name,

        String icon
) {
}
