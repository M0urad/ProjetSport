import { Rencontre } from './../model/rencontre';
import { Router } from '@angular/router';
import { Joueur } from './../model/joueur';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crea-event',
  templateUrl: './crea-event.component.html',
  styleUrls: ['./crea-event.component.css'],
})
export class CreaEventComponent implements OnInit {
  rencontre: Rencontre = new Rencontre();
  joueur: Joueur = new Joueur();

  constructor(private router: Router) {
    this.joueur.nom = 'Zizou';
  }

  ngOnInit(): void {}

  save() {}
}
