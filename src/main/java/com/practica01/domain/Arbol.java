package com.practica01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data // generar por debajo los getter y setter
@Entity
@Table(name="arbol")

public class Arbol implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    
    private Long idArbol;  // id_arbol en la DB ;)
    private String nombre;
    private String especie;
    private int altura;
    private int edad;
    private int diametro;
    private String dureza;

    
    public Arbol() {
    }

    public Arbol(String nombre, String especie, int altura, int edad, int diametro, String dureza) {
        this.nombre = nombre;
        this.especie = especie;
        this.altura = altura;
        this.edad = edad;
        this.diametro = diametro;
        this.dureza = dureza;
    }
    
}
