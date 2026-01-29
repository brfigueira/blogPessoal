import { Routes } from '@angular/router';

import { Login } from './pages/login/login';
import { Cadastro } from './pages/cadastrar/cadastrar';
import { Postagens } from './pages/postagens/postagens';
import { PostagemPage } from './pages/postagem/postagem';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  { path: 'login', component: Login },
  { path: 'cadastro', component: Cadastro },

  { path: 'postagens', component: Postagens },
  { path: 'postagem', component: PostagemPage }
];
