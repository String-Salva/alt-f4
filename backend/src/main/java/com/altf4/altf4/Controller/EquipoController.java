package com.altf4.altf4.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altf4.altf4.entity.Equipo;
import com.altf4.altf4.service.EquipoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    private final EquipoService service;

    public EquipoController(EquipoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Equipo> listarEquipos() {
        return service.listarEquipos();
    }

    @GetMapping("/{id}")
    public Optional<Equipo> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Equipo guardarEquipo(@RequestBody Equipo equipo) {
        return service.guardarEquipo(equipo);
    }

    @PutMapping("/{id}")
    public Equipo actualizarEquipo(@PathVariable Long id,
            @RequestBody Equipo equipo) {
        equipo.setId(id);
        return service.guardarEquipo(equipo);
    }

    @DeleteMapping("/{id}")
    public void eliminarEquipo(@PathVariable Long id) {
        service.eliminarEquipo(id);
    }
}