import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';

import { JugadorService, Jugador } from '../../services/jugador.service';
import { EquipoService, Equipo } from '../../services/equipo.service';

@Component({
  selector: 'app-jugador-list',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './jugador-list.component.html',
  styleUrls: ['./jugador-list.component.css']
})
export class JugadorListComponent implements OnInit {

  @Input() equipoId!: number;

  jugadores: Jugador[] = [];
  formulario: FormGroup;
  mostrarFormulario = false;
  equipo: Equipo | null = null;

  constructor(
    private jugadorService: JugadorService,
    private equipoService: EquipoService,
    private fb: FormBuilder
  ) {

    this.formulario = this.fb.group({
      nombre: ['', Validators.required],
      dorsal: ['', [Validators.required, Validators.min(1), Validators.max(99)]],
      posicion: ['', Validators.required]
    });

  }

  ngOnInit(): void {

    if (this.equipoId) {
      this.cargarEquipo();
      this.cargarJugadores();
    }

  }

  cargarEquipo(): void {

    this.equipoService.obtenerEquipo(this.equipoId).subscribe({
      next: (data) => this.equipo = data,
      error: (error) => console.error(error)
    });

  }

  cargarJugadores(): void {

    this.jugadorService.jugadoresPorEquipo(this.equipoId).subscribe({
      next: (data) => this.jugadores = data,
      error: (error) => console.error(error)
    });

  }

  abrirFormulario(): void {

    this.mostrarFormulario = true;
    this.formulario.reset();

  }

  guardarJugador(): void {

    if (this.formulario.valid) {

      const jugador: Jugador = {
        ...this.formulario.value,
        equipo: {
          id: this.equipoId
        }
      };

      this.jugadorService.crearJugador(jugador).subscribe({
        next: () => {
          this.cargarJugadores();
          this.mostrarFormulario = false;
        },
        error: (error) => console.error(error)
      });

    }

  }

  eliminarJugador(id?: number): void {

    if (id && confirm('¿Eliminar jugador?')) {

      this.jugadorService.eliminarJugador(id).subscribe({
        next: () => this.cargarJugadores(),
        error: (error) => console.error(error)
      });

    }

  }

}