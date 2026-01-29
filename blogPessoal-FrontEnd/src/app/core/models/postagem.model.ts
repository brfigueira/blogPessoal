import { Autor } from './autor.model';
import { Tema } from './tema.model';

export interface Postagem {
  id?: number;
  titulo: string;
  texto: string;
  autor: Autor;
  tema: Tema;
}
