package com.altf4.altf4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altf4.altf4.entity.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    Optional<Equipo> findByNombre(String nombre);

    List<Equipo> findByCiudad(String ciudad);
}