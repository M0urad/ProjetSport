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

  usernameCtrl: FormControl | any = null;
  passwordCtrl: FormControl | any = null;
  form: FormGroup | any = null;

  constructor(
    private loginService: LoginService,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.usernameCtrl = fb.control('', Validators.required);
    this.passwordCtrl = fb.control('', Validators.required);
    this.form = fb.group({
      username: this.usernameCtrl,
      password: this.passwordCtrl,
    });
  }

  ngOnInit(): void {}

  seConnecter() {
    this.loginService.login(this.usernameCtrl, this.passwordCtrl).subscribe(
      (result) => {
        localStorage.setItem('login', this.usernameCtrl);
        localStorage.setItem(
          'auth',
          'Basic ' + btoa(this.usernameCtrl + ':' + this.passwordCtrl)
        );
        this.router.navigate(['/home']);
      },
      (error) => {
        this.message = 'infos incorrect';
      }
    );
  }
}
