package com.project.r2system.domain.budgetSystem.entities;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Budget {
    @Id
    private String id;
    private Integer idN;
    private Integer numeroPresupuesto;
    private String estado;
    private String formaPago;
    private String referencia;
    private Date fechaCreacion;
    private Date fechaValidez;
    private Boolean precio;
    private String tipo;

    // clients attributes
    private String cliente;
    private String nombre;
    private String direccion;
    private String atencion;

    // table attributes





}
