import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { appConfig } from './app/app.config';
import { App } from './app/app';

/*
  Inicializa a aplicação Angular
  - Usa App (standalone)
  - Injeta configurações globais
*/
bootstrapApplication(App, {
  providers: [
    provideHttpClient(),
    ...appConfig.providers
  ]
}).catch(err => console.error(err));
