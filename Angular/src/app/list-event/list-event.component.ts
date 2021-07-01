import { Joueur } from './../model/joueur';
import { Inscription } from './../model/inscription';
import { CompteService } from './../service/compte.service';
import { RencontreService } from './../service/rencontre.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Rencontre } from '../model/rencontre';
import { JoueurService } from '../service/joueur.service';
import { Compte } from '../model/compte';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { InscriptionRencontreService } from '../service/inscription-rencontre.service';

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
  placesReserveesCtrl: FormControl;
  resePlaces: number = 0;

  constructor(
    private rencontreService: RencontreService,
    private inscriptionService: InscriptionRencontreService,
    private joueurService: JoueurService,
    private compteService: CompteService,
    private fb: FormBuilder,
    private router: Router
  ) {
    this.placesReserveesCtrl = this.fb.control('', Validators.required);
  }

  ngOnInit(): void {
    this.rencontres = this.rencontreService.getRencAng();
  }

  delete(id: number) {
    this.rencontreService.delete(id).subscribe((result) => {
      /*this.rencontres = this.rencontreService.getAll();*/
      this.rencontres = this.rencontreService.getRencAng();
    });
  }

  insc(id_rencontre: number) {
    this.inscriptionService
      .sinscrire(id_rencontre, this.placesReserveesCtrl.value)
      .subscribe((result) => {
        this.rencontres = this.rencontreService.getRencAng();
      });

    this.inscription.nbPlaces = this.placesReserveesCtrl.value;
  }

  isInscrit(rencontre: Rencontre): boolean {
    let subscribed: boolean = false;
    for (let b of rencontre.inscriptions) {
      if (b.joueur.username == localStorage.getItem('login')) {
        subscribed = true;
        return subscribed;
      }
    }
    return subscribed;
  }
  isProprio(rencontre: Rencontre): boolean {
    let subscribed: boolean = false;
    if (rencontre.proprio.username == localStorage.getItem('login')) {
      subscribed = true;
    }
    return subscribed;
  }

  isEnough(nbPlaces: number, rencontre: Rencontre): boolean {
    if (this.resPlaces(rencontre) < nbPlaces) {
      return false;
    } else {
      return true;
    }
  }
  resPlaces(rencontre: Rencontre): number {
    let tmp: number = 0;
    console.log(rencontre.inscriptions);
    for (let a of rencontre.inscriptions) {
      tmp = tmp + a.nbPlaces;
    }
    return tmp;
  }

  isAdmin(): boolean {
    if (this.compte.role == 'ROLE_ADMIN') {
      return true;
    } else {
      return false;
    }
  }
}
