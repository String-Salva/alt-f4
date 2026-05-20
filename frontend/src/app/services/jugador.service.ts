import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Jugador {
  id?: number;
  nombre: string;
  dorsal: number;
  posicion: string;
  equipo?: any;
}

@Injectable({
  providedIn: 'root'
})
export class JugadorService {
  private apiUrl = 'http://localhost:8080/api/jugadores';

  constructor(private http: HttpClient) { }

  listarJugadores(): Observable<Jugador[]> {
    return this.http.get<Jugador[]>(this.apiUrl);
  }

  jugadoresPorEquipo(equipoId: number): Observable<Jugador[]> {
    return this.http.get<Jugador[]>(`${this.apiUrl}/equipo/${equipoId}`);
  }

  obtenerJugador(id: number): Observable<Jugador> {
    return this.http.get<Jugador>(`${this.apiUrl}/${id}`);
  }

  crearJugador(jugador: Jugador): Observable<Jugador> {
    return this.http.post<Jugador>(this.apiUrl, jugador);
  }

  editarJugador(id: number, jugador: Jugador): Observable<Jugador> {
    return this.http.put<Jugador>(`${this.apiUrl}/${id}`, jugador);
  }

  eliminarJugador(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}