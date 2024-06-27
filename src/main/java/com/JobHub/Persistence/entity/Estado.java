package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="Estado")
@Getter
@Setter
@NoArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEstado",nullable = false,unique=true)
    private Integer idEstado;

    @Column(nullable = false,length=200)
    private String Descripcion;
    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime FechaRegistro;
    @Column(columnDefinition = "TINYINT")
    private Boolean estado;
}
