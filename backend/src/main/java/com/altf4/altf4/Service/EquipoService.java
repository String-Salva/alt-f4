package com.altf4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.altf4.entity.Equipo;
import com.altf4.repository.EquipoRepository;

@Service
public class EquipoService {

    private final EquipoRepository repository;

    public EquipoService(EquipoRepository repository) {
        this.repository = repository;
    }

    public List<Equipo> listarEquipos() {
        return repository.findAll();
    }

    public Optional<Equipo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Equipo guardarEquipo(Equipo equipo) {
        return repository.save(equipo);
    }

    public void eliminarEquipo(Long id) {
        repository.deleteById(id);
    }
}