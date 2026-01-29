import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from "./shared/header/header";
import { Footer } from "./shared/footer/footer";

/*
  Componente raiz da aplicação
  -----------------------------
  - standalone: true → não usa AppModule
  - selector NÃO é usado diretamente (bootstrap via main.ts)
*/
@Component({
  selector: 'app-root',
  standalone: true,

  /*
    Importa recursos que este componente usa
  */
  imports: [RouterOutlet, Header, Footer],

  /*
    HTML principal da aplicação
  */
  templateUrl: './app.html',

  /*
    CSS global do layout
  */
  styleUrls: ['./app.css']
})
export class App {
  /*
    Classe raiz
    - Normalmente vazia
    - Apenas controla o layout base
  */
}
