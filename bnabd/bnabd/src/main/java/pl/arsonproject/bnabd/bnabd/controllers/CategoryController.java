package pl.arsonproject.bnabd.bnabd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pl.arsonproject.bnabd.bnabd.model.Category;
import pl.arsonproject.bnabd.bnabd.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/save")
    public void Save(@RequestBody Category category) {
        try {
            categoryRepository.save(category);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @GetMapping("/get")
    public List<Category> GetList(){
        List<Category> categories = new ArrayList<>();
        try{

            categories = categoryRepository.findAll();

            return categories;
        }catch (Exception e){

        }
        return categories;
    }
}
