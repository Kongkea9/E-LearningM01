package co.istad.elearning_a01_m1.features.category;



import co.istad.elearning_a01_m1.features.category.cateogryDto.CategoryResponse;
import co.istad.elearning_a01_m1.features.category.cateogryDto.CreateCategoryRequest;
import co.istad.elearning_a01_m1.features.category.cateogryDto.PatchCategoryRequest;
import co.istad.elearning_a01_m1.features.category.cateogryDto.UpdateCategoryRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponse createCategory(
           @Valid @RequestBody CreateCategoryRequest request
    ) {
        return categoryService.createCategory(request);
    }

    @GetMapping("/{id}")
    public CategoryResponse findCategoryById(
            @PathVariable Integer id
    ) {
        return categoryService.findCategoryById(id);
    }

    @GetMapping
    public Page<CategoryResponse> findAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return categoryService.findAllCategories(page, size);
    }

    @PutMapping("/{id}")
    public CategoryResponse updateCategory(
            @Valid
            @PathVariable Integer id,
            @RequestBody UpdateCategoryRequest request
    ) {
        return categoryService.updateCategory(id, request);
    }

    @PatchMapping("/{id}")
    public CategoryResponse partialUpdateCategory(
            @Valid
            @PathVariable Integer id,
            @RequestBody PatchCategoryRequest request
    ) {
        return categoryService.partialUpdateCategory(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(
            @PathVariable Integer id
    ) {
        categoryService.deleteCategory(id);
        return "Category deleted successfully";
    }
}