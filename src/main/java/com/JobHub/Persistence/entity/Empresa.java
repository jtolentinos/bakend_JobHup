package com.JobHub.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Empresa")
@Getter
@Setter
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idEmpresa", nullable=false, unique=true)
    private Integer idEmpresa;

    @Column(nullable = false,length=200)
    private String RazonSocial;

    @Column(nullable = false,length=11)
    private String RUC;
    @Column(nullable = false,length=100)
    private String Rubro;
    @Column(nullable = false,length=150)
    private String Direccion;
    @Column(nullable = false,length=9)
    private int Telefono;


}
