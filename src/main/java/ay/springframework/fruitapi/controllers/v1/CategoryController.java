package ay.springframework.fruitapi.controllers.v1;

import ay.springframework.fruitapi.dtos.CategoryDto;
import ay.springframework.fruitapi.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by aliyussef on 21/03/2021
 */
@Controller
@RequestMapping("api/v1/categories/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {

        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CategoryDto> getCategoryByName(@PathVariable String name) {

        return new ResponseEntity<>(categoryService.getCategoryByName(name), HttpStatus.OK);
    }
}
