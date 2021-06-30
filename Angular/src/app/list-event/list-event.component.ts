import { Joueur } from './../model/joueur';
import { Inscription } from './../model/inscription';
import { LoginService } from './../service/login.service';
import { CompteService } from './../service/compte.service';
import { RencontreService } from './../service/rencontre.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Rencontre } from '../model/rencontre';
import { JoueurService } from '../service/joueur.service';
import { Compte } from '../model/compte';

@Component({
  selector: 'app-list-event',
  templateUrl: './list-event.component.html',
  styleUrls: ['./list-event.component.css'],
})
export class ListEventComponent implements OnInit {
  rencontres: Observable<Rencontre[]> | any = null;
  joueur: Joueur = new Joueur();
  inscription: Inscription = new Inscription();
  place: number = 0;
  compte: Compte = new Compte();

  constructor(
    private rencontreService: RencontreService,
    private joueurService: JoueurService,
    private compteService: CompteService
  ) {}

  ngOnInit(): void {
    this.rencontres = this.rencontreService.getAll();

  }

  delete(id: number) {
    this.rencontreService.delete(id).subscribe((result) => {
      this.rencontres = this.rencontreService.getAll();
    });

  }

  insc(id_rencontre: number) {
    this.joueur = this.joueurService.getByLogin(localStorage.getItem('login'));
    this.inscription = new Inscription( // inscription contient les objets joueur et rencontre alors que la bdd contient les id des deux
      this.joueur,
      this.rencontreService.get(id_rencontre),
      this.place
    );
    // manque le save inscription
  }

  isAdmin(): boolean {
    this.compte = this.compteService.getByLogin(localStorage.getItem('login')); // Compte ou Joueur et renvoie un Observable
    if (this.compte.role == 'ROLE_ADMIN') {
      return true;
    } else {
      return false;
    }
  }
}
