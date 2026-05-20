import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Equipo {
  id?: number;
  nombre: string;
  ciudad: string;
}

@Injectable({
  providedIn: 'root'
})
export class EquipoService {
  private apiUrl = 'http://localhost:8080/api/equipos';

  constructor(private http: HttpClient) { }

  listarEquipos(): Observable<Equipo[]> {
    return this.http.get<Equipo[]>(this.apiUrl);
  }

  obtenerEquipo(id: number): Observable<Equipo> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Equipo>(url);
  }

  crearEquipo(equipo: Equipo): Observable<Equipo> {
    return this.http.post<Equipo>(this.apiUrl, equipo);
  }

  editarEquipo(id: number, equipo: Equipo): Observable<Equipo> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.put<Equipo>(url, equipo);
  }

  eliminarEquipo(id: number): Observable<void> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete<void>(url);
  }
}