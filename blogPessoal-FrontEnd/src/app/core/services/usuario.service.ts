import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Usuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private api = environment.apiUrl + '/usuarios';

  constructor(private http: HttpClient) {}

  cadastrar(usuario: Usuario) {
    return this.http.post(this.api + '/cadastrar', usuario);
  }

  login(usuario: Usuario) {
    return this.http.post(this.api + '/login', usuario);
  }
}
