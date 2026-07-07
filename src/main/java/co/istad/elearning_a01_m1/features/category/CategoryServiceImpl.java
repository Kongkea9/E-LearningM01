package co.istad.elearning_a01_m1.features.category;

import co.istad.elearning_a01_m1.features.category.cateogryDto.CategoryResponse;
import co.istad.elearning_a01_m1.features.category.cateogryDto.CreateCategoryRequest;
import co.istad.elearning_a01_m1.features.category.cateogryDto.PatchCategoryRequest;
import co.istad.elearning_a01_m1.features.category.cateogryDto.UpdateCategoryRequest;

import co.istad.elearning_a01_m1.features.category.exception.CategoryNotFoundException;
import co.istad.elearning_a01_m1.features.category.exception.DuplicateCategoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest request) {

        if (categoryRepository.existsByName(request.name())) {
            throw new DuplicateCategoryException(request.name());
        }

        Category category = new Category();
        category.setName(request.name());
        category.setIcon(request.icon());
        category.setDeleted(false);

        return categoryMapper.mapCategoryToCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse findCategoryById(Integer id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        return categoryMapper.mapCategoryToCategoryResponse(category);
    }

    @Override
    public Page<CategoryResponse> findAllCategories(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        return categoryRepository.findAll(pageable)
                .map(categoryMapper::mapCategoryToCategoryResponse);
    }

    @Override
    public CategoryResponse updateCategory(Integer id, UpdateCategoryRequest request) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        category.setName(request.name());
        category.setIcon(request.icon());

        return categoryMapper.mapCategoryToCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse partialUpdateCategory(Integer id, PatchCategoryRequest request) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        if (request.name() != null) {
            category.setName(request.name());
        }

        if (request.icon() != null) {
            category.setIcon(request.icon());
        }

        return categoryMapper.mapCategoryToCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Integer id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        category.setDeleted(true);
        categoryRepository.save(category);
    }

//    private CategoryResponse categoryMapper.mapCategoryToCategoryResponse(Category category) {
//
//        return CategoryResponse.builder()
//                .id(category.getId())
//                .name(category.getName())
//                .icon(category.getIcon())
//                .isDeleted(category.isDeleted())
//                .build();
//    }
}