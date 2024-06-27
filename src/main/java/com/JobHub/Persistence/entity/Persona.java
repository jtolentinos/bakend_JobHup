package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name="Persona")
@Getter
@Setter
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column(name="idPersona", nullable = false, unique=true)
    private Integer idPersona;
    @Column(nullable = false,length=100)
    private String nombre;
    @Column(nullable = false,length=150)
    private String apellidoPaterno;
    @Column(nullable = false,length=150)
    private String apellidoMaterno;
    @Column(nullable = false,length=8)
    private int DNI;
    @Column(nullable = false)
    private Date fechaNacimiento;
    @Column(columnDefinition = "CHAR(1)")
    private String sexo;
    @Column(nullable = false,length=9)
    private String telefono;
    @Column(nullable = false,length=100)
    private String correo;
    @Column(nullable = false,length=150)
    private String direccion;
    @Column(columnDefinition = "TINYINT")
    private boolean estado;
}
