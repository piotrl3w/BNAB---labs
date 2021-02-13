package pl.arsonproject.bnabd.bnabd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
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
    public ProductsResult GetListByCategoryId(@RequestParam(value = "category_like", defaultValue = "allOfThings") String categoryName, @RequestParam("_sort") String sortDirection, @RequestParam(value = "_limit", defaultValue = "5") int limit, @RequestParam(value = "_page", defaultValue = "1") int page) {
        Long count = 0L;
        List<Product> products = new ArrayList<>();
        try {
            count = productRepository.findAll().stream().count();

            if (!categoryName.equals("allOfThings")) {
                Category category = categoryRepository.findAll().stream().filter(x -> x.getName().equals(categoryName)).collect(Collectors.toList()).get(0);
                if (category == null)
                    products = productRepository.findAll().stream().limit(page == 1 ? limit : (limit*page)).skip(page == 1 ? 0 : (limit*page)-limit).collect(Collectors.toList());
                else
                    products = productRepository.findAll().stream().filter(product -> product.getCategoryId() == category.getId()).limit(page == 1 ? limit : (limit*page)).skip(page == 1 ? 0 : (limit*page)-limit).collect(Collectors.toList());
            } else {
                products = productRepository.findAll();
            }

            if (sortDirection.equals("name")) {
                products.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
            } else if (sortDirection.equals("price")) {
                products.sort((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
            }

            products = products.stream().limit(page == 1 ? limit : (limit*page)).skip(page == 1 ? 0 : (limit*page)-limit).collect(Collectors.toList());


        } catch (Exception e) {

        }


        return new ProductsResult(products,count);
    }

    class ProductsResult {
        public List<Product> list;
        public long count;

        public ProductsResult(List<Product> list, long count) {
            this.list = list;
            this.count = count;
        }
    }
}
