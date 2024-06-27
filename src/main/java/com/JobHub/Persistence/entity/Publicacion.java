package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="Publicacion")
@Getter
@Setter
@NoArgsConstructor
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPublicacion",nullable = false,unique=true)
    private Integer idPublicacion;

    @Column(name="idEmpresa",nullable = false)
    private Integer idEmpresa;

    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime FechaPublicacion;
    @Column(nullable = false,length=200)
    private String Descripcion;
    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime FechaFin;

    @ManyToOne
    @JoinColumn(name="idEmpresa",referencedColumnName = "idEmpresa",insertable=false,updatable=false)
    private Empresa empresa; ;
}
