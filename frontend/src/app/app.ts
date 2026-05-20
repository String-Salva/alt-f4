import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
//import { EquipoListComponent } from './components/equipo-list/equipo-list.component';
//import { JugadorListComponent } from './components/jugador-list/jugador-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    RouterOutlet,
    //EquipoListComponent,
    //JugadorListComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'futbol-app';
}