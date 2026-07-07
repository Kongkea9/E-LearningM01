package co.istad.elearning_a01_m1.features.category.exception;


public class DuplicateCategoryException extends RuntimeException {

    public DuplicateCategoryException(String name) {
        super("Category already exists with name: " + name);
    }
}