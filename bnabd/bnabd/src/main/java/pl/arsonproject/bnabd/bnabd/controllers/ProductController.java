package pl.arsonproject.bnabd.bnabd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pl.arsonproject.bnabd.bnabd.model.Category;
import pl.arsonproject.bnabd.bnabd.model.Product;
import pl.arsonproject.bnabd.bnabd.repository.CategoryRepository;
import pl.arsonproject.bnabd.bnabd.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/save")
    public void Save(@RequestBody Product product) {
        try {

            productRepository.save(product);
        } catch (Exception e) {
            e.getMessage();
        }
    }


    @GetMapping("/get")
    public List<Product> GetListByCategoryId(@RequestParam(value = "category_like", defaultValue = "allOfThings") String categoryName, @RequestParam("_sort") String sortDirection) {
        List<Product> products = new ArrayList<>();
        try {
            if (!categoryName.equals("allOfThings")) {
                Category category = categoryRepository.findAll().stream().filter(x -> x.getName().equals(categoryName)).collect(Collectors.toList()).get(0);
                if (category == null)
                    products = productRepository.findAll();
                else
                    products = productRepository.findAll().stream().filter(product -> product.getCategoryId() == category.getId()).collect(Collectors.toList());
            } else {
                products = productRepository.findAll();
            }

            if (sortDirection.equals("name")) {
                products.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
            } else if (sortDirection.equals("price")) {
                products.sort((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
            }


        } catch (Exception e) {

        }
        return products;
    }

}
