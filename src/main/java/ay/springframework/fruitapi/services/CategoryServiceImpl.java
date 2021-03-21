package ay.springframework.fruitapi.services;

import ay.springframework.fruitapi.dtos.CategoryDto;
import ay.springframework.fruitapi.mappers.CategoryMapper;
import ay.springframework.fruitapi.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aliyussef on 21/03/2021
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDto(categoryRepository.findByName(name));
    }
}
