package co.istad.elearning_a01_m1.features.category;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

  boolean existsByName(String name);
}