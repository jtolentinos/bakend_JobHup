package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="EstadoPublicacion")
@Getter
@Setter
@NoArgsConstructor
public class EstadoPublicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEstadoPublicacion",nullable = false,unique=true)
    private Integer idEstadoPublicacion;

    @Column(name="idEstado",nullable = false)
    private Integer idEstado;

    @Column(name="idPublicacion",nullable = false)
    private Integer idPublicacion;

    @Column(nullable = false,length=200)
    private String Comentario;
    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime FechaInicio;
    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime FechaFin;

    @OneToOne
    @JoinColumn(name="idEstado",referencedColumnName = "idEstado",insertable=false,updatable=false)
    private Estado estado;
    @OneToOne
    @JoinColumn(name="idPublicacion",referencedColumnName = "idPublicacion",insertable=false,updatable=false)
    private Publicacion publicacion;
}
