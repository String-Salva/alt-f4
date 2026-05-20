package com.altf4.altf4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.altf4.altf4.entity.Jugador;
import com.altf4.altf4.repository.JugadorRepository;

@Service
public class JugadorService {

    private final JugadorRepository repository;

    public JugadorService(JugadorRepository repository) {
        this.repository = repository;
    }

    public List<Jugador> listarJugadores() {
        return repository.findAll();
    }

    public Optional<Jugador> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Jugador guardarJugador(Jugador jugador) {
        return repository.save(jugador);
    }

    public void eliminarJugador(Long id) {
        repository.deleteById(id);
    }
}