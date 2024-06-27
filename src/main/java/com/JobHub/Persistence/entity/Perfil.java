package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Perfil")
@Getter
@Setter
@NoArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPerfil", nullable=false, unique=true)
    private Integer idPerfil;
    @Column(name="idPersona", nullable=false)
    private Integer idPersona;

    @Column(nullable = false,length=200)
    public String Experiencia;
    @Column(nullable = false,length=200)
    public String HabilidadesTecnicas;
    @Column(nullable = false,length=200)
    public String HabilidadesBlandas;
    @Column(nullable = false,length=200)
    public String Idiomas;
    @Column(nullable = false,length=200)
    public String Carrera;
    @Column(nullable = false,length=200)
    public String Calificaciones;
    @Column(columnDefinition = "TINYINT")
    private boolean Estado;

    @OneToOne
    @JoinColumn(name="idPersona",referencedColumnName = "idPersona",insertable=false,updatable=false)
    private Persona persona;

}
