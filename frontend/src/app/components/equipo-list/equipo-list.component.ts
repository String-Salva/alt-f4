import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EquipoService, Equipo } from '../../services/equipo.service';
import { JugadorListComponent } from '../jugador-list/jugador-list.component';

@Component({
  selector: 'app-equipo-list',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    JugadorListComponent
  ],
  templateUrl: './equipo-list.component.html',
  styleUrls: ['./equipo-list.component.css']
})
export class EquipoListComponent implements OnInit {
  equipos: Equipo[] = [];
  formulario: FormGroup;
  equipoSeleccionado: Equipo | null = null;
  mostrarFormulario = false;

  constructor(
    private equipoService: EquipoService,
    private fb: FormBuilder
  ) {
    this.formulario = this.fb.group({
      nombre: ['', Validators.required],
      ciudad: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.cargarEquipos();
  }

  cargarEquipos() {
    this.equipoService.listarEquipos().subscribe(
      (data) => this.equipos = data,
      (error) => console.error('Error cargando equipos', error)
    );
  }

  seleccionarEquipo(equipo: Equipo) {
    this.equipoSeleccionado = equipo;
  }

  abrirFormulario() {
    this.mostrarFormulario = true;
    this.formulario.reset();
  }

  guardarEquipo() {
    if (this.formulario.valid) {
      this.equipoService.crearEquipo(this.formulario.value).subscribe(
        () => {
          this.cargarEquipos();
          this.mostrarFormulario = false;
        },
        (error) => console.error('Error creando equipo', error)
      );
    }
  }

  eliminarEquipo(id: number | undefined) {
    if (id && confirm('¿Deseas eliminar este equipo?')) {
      this.equipoService.eliminarEquipo(id).subscribe(
        () => this.cargarEquipos(),
        (error) => console.error('Error eliminando equipo', error)
      );
    }
  }
}