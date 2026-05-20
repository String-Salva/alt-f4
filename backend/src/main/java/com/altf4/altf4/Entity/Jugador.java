package com.altf4.altf4.entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;




  @Entity
  @Table(name = "jugadores")
  public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column
    private Integer dorsal;

    @Column
    private String posicion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo_id", nullable = false)
    @JsonBackReference
    private Equipo equipo;

    // Getters y Setters
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

    public Integer getDorsal() {
      return dorsal;
    }

    public void setDorsal(Integer dorsal) {
      this.dorsal = dorsal;
    }

    public String getPosicion() {
      return posicion;
    }

    public void setPosicion(String posicion) {
      this.posicion = posicion;
    }

    public Equipo getEquipo() {
      return equipo;
    }

    public void setEquipo(Equipo equipo) {
      this.equipo = equipo;
    }

  }

