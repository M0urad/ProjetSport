import { Message } from './../model/message';
import { LoginService } from './../service/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  message: string = '';

  loginCtrl: FormControl | any = null;
  passwordCtrl: FormControl | any = null;
  form: FormGroup | any = null;

  constructor(
    private loginService: LoginService,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.loginCtrl = fb.control('', Validators.required);
    this.passwordCtrl = fb.control('', Validators.required);
    this.form = fb.group({
      login: this.loginCtrl,
      password: this.passwordCtrl,
    });
  }

  ngOnInit(): void {}

  seConnecter() {
    this.loginService.login(this.loginCtrl, this.passwordCtrl).subscribe(
      (result) => {
        localStorage.setItem('login', this.loginCtrl);
        localStorage.setItem(
          'auth',
          'Basic ' + btoa(this.loginCtrl + ':' + this.passwordCtrl)
        );
        this.router.navigate(['/home']);
      },
      (error) => {
        this.message = 'infos incorrect';
      }
    );
  }
}
