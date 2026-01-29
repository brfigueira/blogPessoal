import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Postagem } from '../models/postagem.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostagemService {

  private apiUrl = 'http://localhost:8080/postagens';

  constructor(private http: HttpClient) {}

  /*
    Lista todas as postagens
  */
  listar(): Observable<Postagem[]> {
    return this.http.get<Postagem[]>(this.apiUrl);
  }

  /*
    Cria nova postagem
  */
  cadastrar(postagem: Postagem): Observable<Postagem> {
    return this.http.post<Postagem>(this.apiUrl, postagem);
  }

  /*
    Atualiza postagem
  */
  atualizar(postagem: Postagem): Observable<Postagem> {
    return this.http.put<Postagem>(this.apiUrl, postagem);
  }

  /*
    Remove postagem
  */
  deletar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
