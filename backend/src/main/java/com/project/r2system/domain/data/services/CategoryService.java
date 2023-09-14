package com.project.r2system.domain.data.services;

import com.project.r2system.domain.data.entities.Category;
import com.project.r2system.domain.data.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository CategoryServiceApi;

    public List<Category> allCategories() {
        return CategoryServiceApi.findAll();
    }

    public Category CategoryById(Integer idN) {
        return CategoryServiceApi.findByIdN(idN);
    }
    public Category CategoryByNombre(String name) {
        return CategoryServiceApi.findByNombre(name);
    }

    public String createCategory(Category Category) {
        try {
            CategoryServiceApi.save(Category);
            return "OK";
        } catch (Exception e) {
            return e.getCause().toString();
        }
    }
    /*
    public String updateCategory(Integer idN, Category updatedCategory) {
        try {
            CategoryServiceApi.save(updatedCategory);
            return "OK";
        }catch (Exception e) {
            return e.getCause().toString());
        }
    }*/
}
