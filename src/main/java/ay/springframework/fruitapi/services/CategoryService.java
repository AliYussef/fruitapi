package ay.springframework.fruitapi.services;

import ay.springframework.fruitapi.dtos.CategoryDto;

import java.util.List;

/**
 * Created by aliyussef on 21/03/2021
 */
public interface CategoryService {
    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryByName(String name);
}
