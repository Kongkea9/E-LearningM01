package co.istad.elearning_a01_m1.features.category.cateogryDto;

import lombok.Builder;

@Builder
public record CategoryResponse(

        Integer id,
        String name,
        String icon,
        boolean isDeleted
) {
}
