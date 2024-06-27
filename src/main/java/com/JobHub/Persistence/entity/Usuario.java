package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="Usuario")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsuario", nullable=false, unique=true)
    private Integer idUsuario;
    @Column(name="idPersona", nullable=false, unique=true)
    private Integer idPersona;

    @Column(nullable = false,length=100)
    private String NombreUsua;
    @Column(nullable = false,length=50)
    private String Clave;
    @Column(columnDefinition = "TINYINT")
    private Boolean estado;
    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime FechaRegistro;

    @Column(nullable = false)
    private Boolean esEmpelado;
    @Column(nullable = false)
    private Boolean esEmpelador;

    @OneToOne
    @JoinColumn(name="idPersona",referencedColumnName = "idPersona",insertable=false,updatable=false)
    private Persona persona;

}
