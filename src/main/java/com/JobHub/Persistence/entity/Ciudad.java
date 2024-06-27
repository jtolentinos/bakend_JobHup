package com.JobHub.Persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Ciudad")
@Getter
@Setter
@NoArgsConstructor
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCiudad", nullable = false, unique = true)
    private Integer idCiudad;

    @Column(nullable = false, length = 200)
    private String nombre;

}
