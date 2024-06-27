package com.JobHub.Service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EmpleadorDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String RazonSocial;

    @NotBlank(message = "El Ruc es obligatorio")
    @Pattern(regexp = "\\d{11}", message = "El DNI debe tener 11 dígitos")
    private String RUC;

    @NotBlank(message = "El rubro de la empresa es obligatorio")
    private String Rubro;

    @NotBlank(message = "La dirección es obligatoria")
    private String Direccion;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d{9}", message = "El teléfono debe tener 9 dígitos")
    private String Telefono;

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        RazonSocial = razonSocial;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRubro() {
        return Rubro;
    }

    public void setRubro(String rubro) {
        Rubro = rubro;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
