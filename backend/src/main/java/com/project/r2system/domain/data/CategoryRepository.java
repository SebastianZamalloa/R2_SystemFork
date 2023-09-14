package com.project.r2system.domain.data;

import com.project.r2system.domain.data.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,Integer> {
    Category findByIdN(Integer idN);
    Category findByNombre(String name);
}
