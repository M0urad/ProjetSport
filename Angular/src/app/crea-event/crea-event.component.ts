import { Joueur } from './../model/joueur';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crea-event',
  templateUrl: './crea-event.component.html',
  styleUrls: ['./crea-event.component.css']
})
export class CreaEventComponent implements OnInit {
  joueur:Joueur = new Joueur();
  constructor() {this.joueur.nom="Zizou" }

  ngOnInit(): void {
  }

}
