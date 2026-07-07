package co.istad.elearning_a01_m1.features.category;

import co.istad.elearning_a01_m1.features.category.cateogryDto.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse mapCategoryToCategoryResponse(Category category);

}
