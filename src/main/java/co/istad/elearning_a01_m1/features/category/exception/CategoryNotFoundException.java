package co.istad.elearning_a01_m1.features.category.exception;


public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Integer id) {
        super("Category not found with id: " + id);
    }
}