import { Component, OnInit } from '@angular/core';
import { Compte } from '../model/compte';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  compte: Compte = new Compte();

  constructor() {}

  ngOnInit(): void {}

  public seConnecter() {
    if (this.compte) {
      // Si ce compte existe, alors on redirige l'utilisateur sur la page home mais avec les différentes vues
    } else {
      // Si le compte n'existe pas, message d'erreur
    }
  }
}
