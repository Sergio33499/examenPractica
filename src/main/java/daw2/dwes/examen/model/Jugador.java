package daw2.dwes.examen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Jugador {
    @Column(length = 9)
    @Size(min = 9, max = 9)
    @Id
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @DecimalMin(value = "0")
    private double salario;

    @Min(1)
    @Max(99)
    private int dorsal;

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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @ManyToOne(optional = true)
    @JoinColumn(nullable = false)
    private Equipo equipo;

    public Equipo getEquipoCaptitan() {
        return equipoCaptitan;
    }

    public void setEquipoCaptitan(Equipo equipoCaptitan) {
        this.equipoCaptitan = equipoCaptitan;
    }

    @OneToOne(mappedBy = "capitan", optional = false)
    private Equipo equipoCaptitan;

}
