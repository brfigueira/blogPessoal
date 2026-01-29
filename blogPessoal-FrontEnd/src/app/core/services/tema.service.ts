import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tema } from '../models/tema.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TemaService {

  private apiUrl = 'http://localhost:8080/temas';

  constructor(private http: HttpClient) {}

  listar(): Observable<Tema[]> {
    return this.http.get<Tema[]>(this.apiUrl);
  }

  cadastrar(tema: Tema): Observable<Tema> {
    return this.http.post<Tema>(this.apiUrl, tema);
  }
}
