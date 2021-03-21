package ay.springframework.fruitapi.repositories;

import ay.springframework.fruitapi.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aliyussef on 21/03/2021
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
