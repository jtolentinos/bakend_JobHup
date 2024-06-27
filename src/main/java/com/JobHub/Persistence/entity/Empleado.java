package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="Empleado")
@Getter
@Setter
@NoArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idEmpleado", nullable=false, unique=true)
    private Integer idEmpleado;

    @Column (name="idPersona", nullable=false)
    private Integer idPersona;

    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime FechaRegistro;
    @Column(columnDefinition = "TINYINT")
    private boolean Estado;

    @OneToOne
    @JoinColumn(name="idPersona",referencedColumnName = "idPersona",insertable=false,updatable=false)
    private Persona personas;
}
