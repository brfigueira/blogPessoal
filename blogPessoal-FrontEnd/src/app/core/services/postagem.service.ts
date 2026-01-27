import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Postagem } from '../models/postagem.model';

@Injectable({
    providedIn: 'root'
})
export class PostagemService {
    private api = environment.apiUrl + '/postagens';

    constructor(private http: HttpClient) {}

    listar() {
        return this.http.get<Postagem[]>(this.api);
    }

    criar(postagem: Postagem) {
        return this.http.post(this.api, postagem);
    }

    atualizar(postagem: Postagem) {
        return this.http.put(this.api, postagem);
    }

    deletar(id: number) {
        return this.http.delete(`${this.api}/${id}`)
    }
}