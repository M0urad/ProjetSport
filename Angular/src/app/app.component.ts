import { Observable } from 'rxjs';
import { JoueurService } from './service/joueur.service';
import { Joueur } from './model/joueur';
import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Angular';
  prenom: string | any = null;

  constructor(private router: Router, private joueurService: JoueurService) {}

  isLogged(): boolean {
    this.prenom = localStorage.getItem('prenom');
    return localStorage.getItem('login') ? true : false;
  }

  logoff() {
    localStorage.clear();
    this.router.navigate(['/home']);
  }
}
