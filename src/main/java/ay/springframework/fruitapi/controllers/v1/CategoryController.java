package ay.springframework.fruitapi.controllers.v1;

import ay.springframework.fruitapi.dtos.CategoryDto;
import ay.springframework.fruitapi.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by aliyussef on 21/03/2021
 */
@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDto> getAllCategories() {

        return categoryService.getAllCategories();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDto getCategoryByName(@PathVariable String name) {

        return categoryService.getCategoryByName(name);
    }
}
