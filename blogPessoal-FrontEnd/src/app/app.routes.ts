import { Routes } from '@angular/router';
import { LoginComponent} from './pages/login/login.component';
import { Cadastro } from './pages/cadastro/cadastro';

export const routes: Routes = [
    {path: 'login', component: LoginComponent },
    {path: 'cadastro', component: Cadastro},
    {path: '', redirectTo: 'login', pathMatch:'full'}
];
