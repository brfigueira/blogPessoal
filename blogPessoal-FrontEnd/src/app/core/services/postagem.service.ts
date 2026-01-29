import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Postagem } from '../models/postagem.model';

@Injectable({
  providedIn: 'root'
})
export class PostagemService {

  private apiUrl = 'http://localhost:8080/postagens';

  constructor(private http: HttpClient) {}

  listar(): Observable<Postagem[]> {
    return this.http.get<Postagem[]>(this.apiUrl);
  }

  criar(postagem: Postagem): Observable<Postagem> {
    return this.http.post<Postagem>(this.apiUrl, postagem);
  }

  atualizar(postagem: Postagem): Observable<Postagem> {
    return this.http.put<Postagem>(this.apiUrl, postagem);
  }

  deletar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
