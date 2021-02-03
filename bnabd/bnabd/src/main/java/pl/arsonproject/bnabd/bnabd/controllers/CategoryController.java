package pl.arsonproject.bnabd.bnabd.controllers;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.arsonproject.bnabd.bnabd.model.Category;
import pl.arsonproject.bnabd.bnabd.repository.CategoryRepository;
import pl.arsonproject.bnabd.bnabd.repository.HibernateUtil;

@RestController
@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/save")
    public void Save(@RequestBody Category category) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            categoryRepository.save(category);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
