import { InscriptionComponent } from './inscription/inscription.component';
import { CreaEventComponent } from './crea-event/crea-event.component';
import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'creationEvent', component:CreaEventComponent},
  { path: 'Inscription', component:InscriptionComponent}
];
