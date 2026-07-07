package co.istad.elearning_a01_m1.features.category;


import co.istad.elearning_a01_m1.features.category.cateogryDto.CategoryResponse;
import co.istad.elearning_a01_m1.features.category.cateogryDto.CreateCategoryRequest;
import co.istad.elearning_a01_m1.features.category.cateogryDto.PatchCategoryRequest;
import co.istad.elearning_a01_m1.features.category.cateogryDto.UpdateCategoryRequest;
import org.springframework.data.domain.Page;

public interface CategoryService {

    CategoryResponse createCategory(CreateCategoryRequest request);

    CategoryResponse findCategoryById(Integer id);

    Page<CategoryResponse> findAllCategories(int page, int size);

    CategoryResponse updateCategory(Integer id, UpdateCategoryRequest request);
    CategoryResponse partialUpdateCategory(Integer id, PatchCategoryRequest request);

    void deleteCategory(Integer id);
}