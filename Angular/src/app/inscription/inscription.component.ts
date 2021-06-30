import { Joueur } from './../model/joueur';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { JoueurService } from './../service/joueur.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  usernameCtrl: FormControl;
  passwordCtrl: FormControl;
  nomCtrl: FormControl;
  prenomCtrl: FormControl;
  dateCtrl: FormControl;
  mailCtrl: FormControl;
  telephoneCtrl: FormControl;
  form: FormGroup;

  Joueur: Joueur = new Joueur();

  constructor(
    private JoueurService: JoueurService,
    private aR: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.usernameCtrl=fb.control('')
    this.passwordCtrl=fb.control('')
    this.nomCtrl=fb.control('')
    this.prenomCtrl=fb.control('')
    this.dateCtrl=fb.control('')
    this.mailCtrl=fb.control('')
    this.telephoneCtrl=fb.control('')

    this.form = fb.group({
      login: this.usernameCtrl,
      password: this.passwordCtrl,
      nom: this.nomCtrl,
      prenom: this.prenomCtrl,
      date: this.dateCtrl,
      mail: this.mailCtrl,
      telephone: this.telephoneCtrl
    });


   }

   submit() {
    console.log(this.form);
    console.log(this.usernameCtrl.value);
    console.log(this.passwordCtrl.value);
    console.log(this.nomCtrl.value);
    console.log(this.prenomCtrl.value);
    console.log(this.dateCtrl.value);
    console.log(this.mailCtrl.value);
    console.log(this.telephoneCtrl.value);
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params.id) {
        this.JoueurService.get(params.id).subscribe((data) => {
          this.Joueur = data;
          this.usernameCtrl.setValue(this.Joueur.login);
          this.passwordCtrl.setValue(this.Joueur.password);
          this.mailCtrl.setValue(this.Joueur.mail);
          this.telephoneCtrl.setValue(this.Joueur.numTel)
          this.nomCtrl.setValue(this.Joueur.nom)
          this.prenomCtrl.setValue(this.Joueur.prenom)
        });
      }
    });
  }

  save() {
    this.Joueur = new Joueur(
      this.usernameCtrl.value,
      this.passwordCtrl.value,
      this.prenomCtrl.value,
      this.nomCtrl.value,
      this.dateCtrl.value,
      this.mailCtrl.value,
      this.telephoneCtrl.value
    );
    if (this.Joueur.id) {
      this.JoueurService.update(this.Joueur).subscribe((result) => {
        this.router.navigate(['/home']);
      });
    } else {
      this.JoueurService.create(this.Joueur).subscribe((result) => {
        this.router.navigate(['/home']);
      });
    }
  }
}
