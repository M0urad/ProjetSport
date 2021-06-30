import { Role } from './../model/role';
import { Joueur } from './../model/joueur';
import {
  FormControl,
  FormGroup,
  FormBuilder,
  Validators,
} from '@angular/forms';
import { JoueurService } from './../service/joueur.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  idCtrl: FormControl;
  usernameCtrl: FormControl;
  passwordCtrl: FormControl;
  confirmCtrl: FormControl;
  nomCtrl: FormControl;
  prenomCtrl: FormControl;

  mailCtrl: FormControl;
  telephoneCtrl: FormControl;
  passwordGroup: FormGroup;
  form: FormGroup;

  joueur: Joueur = new Joueur();

  constructor(
    private JoueurService: JoueurService,
    private aR: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.idCtrl = fb.control('');
    this.usernameCtrl = fb.control('', Validators.required);
    this.passwordCtrl = fb.control('');
    this.confirmCtrl = fb.control('');
    this.passwordGroup = fb.group(
      {
        password: this.passwordCtrl,
        confirm: this.confirmCtrl,
      },
      { validators: this.checkPassword }
    );

    this.nomCtrl = fb.control('');
    this.prenomCtrl = fb.control('');

    this.mailCtrl = fb.control('');
    this.telephoneCtrl = fb.control('');

    this.form = fb.group({
      id: this.idCtrl,
      login: this.usernameCtrl,
      passwordGroup: this.passwordGroup,
      nom: this.nomCtrl,
      prenom: this.prenomCtrl,
      mail: this.mailCtrl,
      telephone: this.telephoneCtrl,
    });
  }

  submit() {
    console.log(this.form);
  }

  ngOnInit(): void {}

  save() {
    this.joueur = new Joueur(
      this.idCtrl.value,
      this.usernameCtrl.value,
      this.passwordCtrl.value,
      Role.USER,
      this.mailCtrl.value,
      this.nomCtrl.value,
      this.prenomCtrl.value,
      this.telephoneCtrl.value
    );
    if (this.joueur.id) {
      this.JoueurService.update(this.joueur).subscribe((result) => {
        this.router.navigate(['/home']);
      });
    } else {
      this.JoueurService.create(this.joueur).subscribe((result) => {
        this.router.navigate(['/home']);
      });
    }
  }

  checkPassword(group: FormGroup) {
    const password = group.controls.password;
    const confirm = group.controls.confirm;
    if (password.errors) {
      return null;
    }
    return password.value != confirm.value ? { notMatch: true } : null;
  }
}
