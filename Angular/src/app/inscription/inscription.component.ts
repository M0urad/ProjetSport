import { FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { Compte } from './../model/compte';
import { CompteService } from './../service/compte.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  loginCtrl: FormControl;
  passwordCtrl: FormControl;
  nomCtrl: FormControl;
  prenomCtrl: FormControl;
  dateCtrl: FormControl;
  mailCtrl: FormControl;
  telephoneCtrl: FormControl;
  form: FormGroup;

  compte: Compte = new Compte();

  constructor(
    private CompteService: CompteService,
    private aR: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.loginCtrl=fb.control('')
    this.passwordCtrl=fb.control('')
    this.nomCtrl=fb.control('')
    this.prenomCtrl=fb.control('')
    this.dateCtrl=fb.control('')
    this.mailCtrl=fb.control('')
    this.telephoneCtrl=fb.control('')

    this.form = fb.group({
      login: this.loginCtrl,
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
    console.log(this.loginCtrl.value);
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
        this.CompteService.get(params.id).subscribe((data) => {
          this.compte = data;
          this.loginCtrl.setValue(this.compte.login);
          this.passwordCtrl.setValue(this.compte.password);
          this.mailCtrl.setValue(this.compte.mail);
        });
      }
    });
  }

  save() {
    this.compte = new Compte(
      this.loginCtrl.value,
      this.passwordCtrl.value,
      this.prenomCtrl.value,
      this.nomCtrl.value,


    );
    if (this.compte.id) {
      this.CompteService.update(this.compte).subscribe((result) => {
        this.router.navigate(['/home']);
      });
    } else {
      this.CompteService.create(this.compte).subscribe((result) => {
        this.router.navigate(['/home']);
      });
    }
  }
}
