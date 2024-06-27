package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="DetallePublicacion")
@Getter
@Setter
@NoArgsConstructor
public class DetallePublicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDetallePublicacion",nullable = false,unique=true)
    private Integer idDetallePublicacion;


    @Column(name="idPublicacion",nullable = false)
    private int idPublicacion;


    @Column(name="idEmpleo",nullable = false)
    private int idEmpleo;

    @Column(columnDefinition = "TINYINT")
    private Boolean estado;

    @OneToOne
    @JoinColumn(name="idPublicacion",referencedColumnName = "idPublicacion",insertable=false,updatable=false)
    private Publicacion publicacion;

    @ManyToOne
    @JoinColumn(name="idEmpleo",referencedColumnName = "idEmpleo",insertable=false,updatable=false)
    private Empleo empleo;
}
