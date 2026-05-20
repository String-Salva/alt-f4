package com.altf4.altf4.controller;

import com.altf4.altf4.entity.Jugador;
import com.altf4.altf4.entity.Equipo;

import com.altf4.altf4.repository.JugadorRepository;
import com.altf4.altf4.repository.EquipoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = "http://localhost:4200")
public class JugadorController {
    
    @Autowired
    private JugadorRepository jugadorRepository;
    
    @Autowired
    private EquipoRepository equipoRepository;
    
    // GET: Listar todos los jugadores
    @GetMapping
    public List<Jugador> listarJugadores() {
        return jugadorRepository.findAll();
    }
    
    // GET: Listar jugadores por equipo
    @GetMapping("/equipo/{equipoId}")
    public List<Jugador> jugadoresPorEquipo(@PathVariable Long equipoId) {
        return jugadorRepository.findByEquipoId(equipoId);
    }
    
    // GET: Ver detalles de un jugador
    @GetMapping("/{id}")
    public Optional<Jugador> obtenerJugador(@PathVariable Long id) {
        return jugadorRepository.findById(id);
    }
    
    // POST: Crear nuevo jugador
    @PostMapping
    public Jugador crearJugador(@RequestBody Jugador jugador) {
        return jugadorRepository.save(jugador);
    }
    
    // PUT: Editar jugador
    @PutMapping("/{id}")
    public Jugador editarJugador(@PathVariable Long id, @RequestBody Jugador jugadorActualizado) {
        return jugadorRepository.findById(id).map(jugador -> {
            jugador.setNombre(jugadorActualizado.getNombre());
            jugador.setDorsal(jugadorActualizado.getDorsal());
            jugador.setPosicion(jugadorActualizado.getPosicion());
            if (jugadorActualizado.getEquipo() != null) {
                jugador.setEquipo(jugadorActualizado.getEquipo());
            }
            return jugadorRepository.save(jugador);
        }).orElse(null);
    }
    
    // DELETE: Eliminar jugador
    @DeleteMapping("/{id}")
    public void eliminarJugador(@PathVariable Long id) {
        jugadorRepository.deleteById(id);
    }
}