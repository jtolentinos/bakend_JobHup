package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Empleo")
@Getter
@Setter
@NoArgsConstructor
public class Empleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEmpleo",nullable = false,unique=true)
    private Integer idEmpleo;

    @Column(name="idCategoria",nullable = false)
    private int idCategoria;

    @Column(name="idCiudad",nullable = false)
    private int idCiudad;

    @Column(nullable = false,length=200)
    public String Nombre;
    @Column(nullable = false,length=200)
    public String Descripcion;
    @Column(nullable = false,length=200)
    public String ExperienciaRequerida;
    @Column(nullable = false,length=200)
    public String CarrerasAfines;
    @Column(nullable = false,length=200)
    public String ModoEmpleo;
    @Column(nullable = false,length=200)
    public String Direccion;
    @Column(nullable = false,length=200)
    public String TipoHorarion;

    @OneToOne
    @JoinColumn(name="idCategoria",referencedColumnName = "idCategoria",insertable=false,updatable=false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idCiudad",referencedColumnName = "idCiudad",insertable=false,updatable=false )
    private Ciudad ciudad;
}
