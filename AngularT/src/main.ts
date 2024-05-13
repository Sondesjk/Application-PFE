import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';

// Importation de jQuery de manière asynchrone
import('jquery').then($ => {
  // Le code de votre application qui utilise jQuery va ici
}).catch(error => console.error('Erreur lors du chargement de jQuery :', error));

// Importation de Bootstrap
import 'bootstrap';

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
