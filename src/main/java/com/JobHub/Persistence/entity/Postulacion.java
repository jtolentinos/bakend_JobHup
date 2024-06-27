package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name="Postulacion")
@Getter
@Setter
@NoArgsConstructor
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPostulacion",nullable = false,unique=true)
    private Integer idPostulacion;


    @Column(name="idDetallePublicacion",nullable = false,unique=true)
    private Integer idDetallePublicacion;

    @Column(name="idEmpleado",nullable = false,unique=true)
    private Integer idEmpleado;

    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime FechaPostulacion;
    @Column(columnDefinition = "TINYINT")
    private Boolean estado;

    @OneToOne
    @JoinColumn(name="idDetallePublicacion",referencedColumnName = "idDetallePublicacion",insertable=false,updatable=false)
    private DetallePublicacion detallePublicacion;

    @ManyToOne
    @JoinColumn(name="idEmpleado",referencedColumnName = "idEmpleado",insertable=false,updatable=false)
    private Empleado empleado;

}
