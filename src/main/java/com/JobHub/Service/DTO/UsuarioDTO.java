package com.JobHub.Service.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class UsuarioDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String Nombre;

    @NotBlank(message = "El apellido paterno es obligatorio")
    private String ApellidoPaterno;

    @NotBlank(message = "El apellido materno es obligatorio")
    private String ApellidoMaterno;

    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(regexp = "\\d{8}", message = "El DNI debe tener 8 dígitos")
    private int Dni;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    private String FechaNacimiento;

    @NotBlank(message = "El sexo es obligatorio")
    @Pattern(regexp = "^(M|F)$", message = "El sexo debe ser 'Masculino' o 'Femenino'")
    private String Sexo;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d{9}", message = "El teléfono debe tener 9 dígitos")
    private String Telefono;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe ser válido")
    private String Correo;

    @NotBlank(message = "La dirección es obligatoria")
    private String Direccion;

    @NotBlank(message = "ingrese usuario")
    private String NombreUsua;

    @NotBlank(message = "ingrese Clave")
    private String ClaveUsua;

    // Getters y Setters

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.ApellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.ApellidoMaterno = apellidoMaterno;
    }

    public int getDni() {
        return Dni;
    }

    public void setDni(int dni) {
        this.Dni = dni;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.FechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        this.Sexo = sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        this.Correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }
    public String getNombreUsua() {
        return NombreUsua;
    }
    public void setNombreUsua(String nombreUsua) {
        this.NombreUsua = nombreUsua;
    }
    public String getClaveUsua() {
        return ClaveUsua;
    }
    public void setClaveUsua(String claveUsua) {
        this.ClaveUsua = claveUsua;
    }
}
