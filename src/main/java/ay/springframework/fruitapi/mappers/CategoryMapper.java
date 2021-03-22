package ay.springframework.fruitapi.mappers;

import ay.springframework.fruitapi.domain.Category;
import ay.springframework.fruitapi.dtos.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 * Created by aliyussef on 21/03/2021
 */
@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto categoryToCategoryDto(Category category);
}
