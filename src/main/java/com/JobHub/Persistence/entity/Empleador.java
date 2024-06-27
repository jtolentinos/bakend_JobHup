package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Empleador")
@Getter
@Setter
@NoArgsConstructor
public class Empleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEmpleador",nullable = false,unique=true)
    private Integer idEmpleador;


    @Column(name="idPersona",nullable = false)
    private Integer idPersona;

    @Column(name="idEmpresa",nullable = false)
    private Integer idEmpresa;

    @Column(nullable = false,length=200)
    private String cargo;
    @Column(columnDefinition = "TINYINT")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name="idEmpresa",referencedColumnName = "idEmpresa",insertable=false,updatable=false)
    private Empresa empresa;
    @OneToOne
    @JoinColumn(name="idPersona", referencedColumnName = "idPersona", insertable = false,updatable = false)
    private Persona persona;
}
