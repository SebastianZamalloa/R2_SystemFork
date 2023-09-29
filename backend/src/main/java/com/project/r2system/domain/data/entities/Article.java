package com.project.r2system.domain.data.entities;

import com.project.r2system.domain.data.payloads.ArticleResponse;
import com.project.r2system.domain.data.services.CategoryService;
import com.project.r2system.domain.data.services.MeasureService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "article")
public class Article {
    @Id
    private String id;
    private Integer idN;
    private String nombre;
    private Integer categoria;
    private EType tipo;
    private Integer medida;
    private Float precio;
    private Float impuesto;
    private Float stock;
    private Integer stockMin;
    private Integer stockMax;
    private Boolean estado;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private MeasureService measureService;
    @Autowired
    private ModelMapper modelMapper;

}
