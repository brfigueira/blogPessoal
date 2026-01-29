import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

import { PostagemService } from '../../core/services/postagem.service';
import { AutorService } from '../../core/services/autor.service';
import { TemaService } from '../../core/services/tema.service';

import { Postagem } from '../../core/models/postagem.model';
import { Autor } from '../../core/models/autor.model';
import { Tema } from '../../core/models/tema.model';

@Component({
  selector: 'app-postagem',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './postagem.html',
  styleUrls: ['./postagem.css']
})
export class PostagemPage implements OnInit {

  // Lista de autores para o <select>
  autores: Autor[] = [];

  // Lista de temas para o <select>
  temas: Tema[] = [];

  // Objeto que será enviado no POST /postagens
  postagem: Postagem = {
    titulo: '',
    texto: '',
    autor: { id: 1, nome: '', email: '' }, // placeholder (vai ser trocado no select)
    tema: { id: 1, descricao: '' }         // placeholder (vai ser trocado no select)
  };

  constructor(
    private postagemService: PostagemService,
    private autorService: AutorService,
    private temaService: TemaService
  ) {}

  ngOnInit(): void {
    this.carregarAutores();
    this.carregarTemas();
  }

  private carregarAutores(): void {
    this.autorService.listar().subscribe({
      next: (res: Autor[]) => {
        this.autores = res;

        // se tiver autores, já seleciona o primeiro por padrão
        if (this.autores.length > 0) {
          this.postagem.autor = this.autores[0];
        }
      },
      error: (err: HttpErrorResponse) => {
        console.error('Erro ao carregar autores:', err);
      }
    });
  }

  private carregarTemas(): void {
    this.temaService.listar().subscribe({
      next: (res: Tema[]) => {
        this.temas = res;

        // se tiver temas, já seleciona o primeiro por padrão
        if (this.temas.length > 0) {
          this.postagem.tema = this.temas[0];
        }
      },
      error: (err: HttpErrorResponse) => {
        console.error('Erro ao carregar temas:', err);
      }
    });
  }

  publicar(): void {
    // validação básica
    if (!this.postagem.titulo.trim() || !this.postagem.texto.trim()) {
      alert('Preencha título e texto.');
      return;
    }

    // IMPORTANTE:
    // seu backend geralmente espera "autor: { id: X }" e "tema: { id: Y }"
    // então garantimos que o objeto enviado tenha pelo menos os IDs.
    const payload: Postagem = {
      titulo: this.postagem.titulo,
      texto: this.postagem.texto,
      autor: { id: this.postagem.autor?.id } as Autor,
      tema: { id: this.postagem.tema?.id } as Tema
    };

    this.postagemService.criar(payload).subscribe({
      next: () => {
        alert('Postagem criada com sucesso!');
        this.limparFormulario();
      },
      error: (err: HttpErrorResponse) => {
        console.error('Erro ao criar postagem:', err);
        alert('Erro ao criar postagem. Veja o console.');
      }
    });
  }

  private limparFormulario(): void {
    this.postagem.titulo = '';
    this.postagem.texto = '';
    // mantém autor/tema selecionados
  }
}
