import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Autor } from '../models/autor.model';
import { Observable } from 'rxjs';

/*
  @Injectable
  Diz ao Angular que esta classe pode ser injetada
  em qualquer lugar do sistema
*/
@Injectable({
  providedIn: 'root' // service global
})
export class AutorService {

  /*
    URL base da API de autores
    Deve apontar exatamente para o backend
  */
  private apiUrl = 'http://localhost:8080/autores';

  /*
    HttpClient permite fazer GET, POST, PUT, DELETE
  */
  constructor(private http: HttpClient) {}

  /*
    GET → listar todos os autores
  */
  listar(): Observable<Autor[]> {
    return this.http.get<Autor[]>(this.apiUrl);
  }

  /*
    POST → cadastrar novo autor
  */
  cadastrar(autor: Autor): Observable<Autor> {
    return this.http.post<Autor>(this.apiUrl, autor);
  }

  /*
    GET por ID → buscar autor específico
  */
  buscarPorId(id: number): Observable<Autor> {
    return this.http.get<Autor>(`${this.apiUrl}/${id}`);
  }
}
