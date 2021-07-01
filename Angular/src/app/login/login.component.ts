import { JoueurService } from './../service/joueur.service';
import { LoginService } from './../service/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Joueur } from '../model/joueur';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  message: string = '';
  pseudo: string = '';
  joueur: Joueur = new Joueur();
  usernameCtrl: FormControl | any = null;
  passwordCtrl: FormControl | any = null;
  form: FormGroup | any = null;

  constructor(
    private loginService: LoginService,
    private router: Router,
    private fb: FormBuilder,
    private joueurService: JoueurService
  ) {
    this.usernameCtrl = fb.control('', Validators.required);
    this.passwordCtrl = fb.control('', Validators.required);
    this.form = fb.group({
      username: this.usernameCtrl,
      password: this.passwordCtrl,
    });
    //this.pseudo = this.usernameCtrl.value;
  }

  ngOnInit(): void {}

  seConnecter() {
    this.loginService
      .login(this.usernameCtrl.value, this.passwordCtrl.value)
      .subscribe(
        (result) => {
          localStorage.setItem('login', this.usernameCtrl.value);
          localStorage.setItem(
            'auth',
            'Basic ' +
              btoa(this.usernameCtrl.value + ':' + this.passwordCtrl.value)
          );
          localStorage.setItem('prenom', result.prenom);

          this.router.navigate(['/home']);
        },
        (error) => {
          this.message = 'infos incorrect';
        }
      );
  }
}
