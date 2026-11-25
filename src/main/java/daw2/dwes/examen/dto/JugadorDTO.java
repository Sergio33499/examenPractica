package daw2.dwes.examen.dto;

import jakarta.validation.constraints.*;

public class JugadorDTO {
    @NotBlank @Size(min = 9, max = 9)
    private String dni;

    @NotBlank
    private String nombre;

    @NotNull @DecimalMin(value = "0")
    private Double salario;

    @NotNull @Min(1) @Max(99)
    private Integer dorsal;

    @NotNull
    private Long equipoId;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Long getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(Long equipoId) {
        this.equipoId = equipoId;
    }
}
