package com.clinicaveterinaria.huellitas.model;

import com.clinicaveterinaria.huellitas.enums.ESPECIE;
import jakarta.persistence.*;

@Entity
@Table(name = "MASCOTAS")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "especie", nullable = false)
    @Enumerated(EnumType.STRING)
    private ESPECIE especie;
    @Column (name = "raza", nullable = false)
    private String raza;
    @Column(name = "edad", nullable = false)
    private int edad;


    public Mascota() {
    }
    public Mascota(Long id, String nombre, ESPECIE especie,String raza, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza=raza;
        this.edad = edad;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ESPECIE getEspecie() {
        return especie;
    }
    public void setEspecie(ESPECIE especie) {
        this.especie = especie;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}