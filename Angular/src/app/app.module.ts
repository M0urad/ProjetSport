import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
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
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
