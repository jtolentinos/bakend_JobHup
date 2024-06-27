package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="Notificaciones")
@Getter
@Setter
@NoArgsConstructor
public class Notificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idNotificacion",nullable = false,unique=true)
    private Integer idNotificacion;
    @Column(name="idUsaurioOrigen",nullable = false)
    private int idUsaurioOrigen;
    @Column(name="idUsuarioDestino",nullable = false)
    private int idUsuarioDestino;
    @Column(nullable = false,length=200)
    private String Descripcion;
    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime FechaNotificacion;
    @Column(columnDefinition = "TINYINT")
    private Boolean estado;


    @ManyToOne
    @JoinColumn(name="idUsaurioOrigen",referencedColumnName = "idUsuario",insertable=false,updatable=false)
    private Usuario usuarioOrigen;

    @ManyToOne
    @JoinColumn(name="idUsuarioDestino",referencedColumnName = "idUsuario",insertable=false,updatable=false)
    private Usuario usuarioDestino;
}
