import { InscriptionComponent } from './inscription/inscription.component';
import { NgModule } from '@angular/core';
import { FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { CreaEventComponent } from './crea-event/crea-event.component';
import { LoginComponent } from './login/login.component';
import { routes } from './routes';
import { HomeComponent } from './home/home.component';
import { ListEventComponent } from './list-event/list-event.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    CreaEventComponent,
    ListEventComponent,
    InscriptionComponent,

  ],
  imports: [
    FormsModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
