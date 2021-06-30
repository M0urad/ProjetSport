import { RencontreService } from './../service/rencontre.service';
import { Rencontre } from './../model/rencontre';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Joueur } from '../model/joueur';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Lieu } from '../model/lieu';

@Component({
  selector: 'app-crea-event',
  templateUrl: './crea-event.component.html',
  styleUrls: ['./crea-event.component.css'],
})
export class CreaEventComponent implements OnInit {
  rencontre: Rencontre = new Rencontre();
  joueur: Joueur = new Joueur();

  idCtrl: FormControl;
  nomCtrl: FormControl;
  dateCtrl: FormControl;
  numVoieCtrl: FormControl;
  voieCtrl: FormControl;
  villeCtrl: FormControl;
  placesCtrl: FormControl;
  cpCtrl: FormControl;
  lieuGroup: FormGroup;
  form: FormGroup;

  constructor(
    private rencontreService: RencontreService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder,
    private aR: ActivatedRoute
  ) {
    this.nomCtrl = this.fb.control('', Validators.required);
    this.idCtrl = this.fb.control('');
    this.dateCtrl = this.fb.control('', Validators.required);
    this.voieCtrl = this.fb.control('');
    this.placesCtrl = this.fb.control('', Validators.required);
    this.numVoieCtrl = this.fb.control('');
    this.villeCtrl = this.fb.control('');
    this.cpCtrl = this.fb.control('');
    this.lieuGroup = this.fb.group({
      numero: this.numVoieCtrl,
      voie: this.voieCtrl,
      ville: this.villeCtrl,
      cp: this.cpCtrl,
    });
    this.form = this.fb.group({
      id: this.idCtrl,
      nom: this.nomCtrl,
      date: this.dateCtrl,
      lieu: this.lieuGroup,
      nbPlace: this.placesCtrl,
    });
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params.id) {
        this.rencontreService.get(params.id).subscribe((data) => {
          this.rencontre = data;
          this.idCtrl.setValue(this.rencontre.id);
          this.nomCtrl.setValue(this.rencontre.nom);
          this.dateCtrl.setValue(this.rencontre.date);
          this.cpCtrl.setValue(this.rencontre.lieu.codePostal);
          this.voieCtrl.setValue(this.rencontre.lieu.voie);
          this.villeCtrl.setValue(this.rencontre.lieu.ville);
          this.numVoieCtrl.setValue(this.rencontre.lieu.numero);
          this.placesCtrl.setValue(this.rencontre.nbPlaces);
        });
      }
    });
  }

  public save() {
    this.rencontre = new Rencontre(
      this.idCtrl.value,
      this.nomCtrl.value,
      this.dateCtrl.value,
      new Lieu(
        '',
        this.numVoieCtrl.value,
        this.voieCtrl.value,
        this.villeCtrl.value,
        this.cpCtrl.value
      ),
      this.placesCtrl.value
    );
    if (this.rencontre.id) {
      this.rencontreService.update(this.rencontre).subscribe((res) => {
        this.router.navigate(['/listEvents'], {
          queryParams: { update: this.rencontre.id },
        });
      });
    } else {
      this.rencontreService.create(this.rencontre).subscribe((res) => {
        this.router.navigate(['/listEvents'], {
          queryParams: { create: res.id },
        });
      });
    }
  }
}
