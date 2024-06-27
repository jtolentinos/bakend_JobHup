package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Categoria")
@Getter
@Setter
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCategoria",nullable = false,unique=true)
    private Integer idCategoria;

    @Column(nullable = false,length=200)
    private String Descripcion;
    @Column(columnDefinition = "TINYINT")
    private Boolean estado;

}
