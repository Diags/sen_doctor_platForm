package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sen_doctor.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
