import { LoginService } from './../service/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login: string = '';
  password: string = '';
  message: string = '';

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {}

  seConnecter() {
    this.loginService.login(this.login, this.password).subscribe(
      (result) => {
        localStorage.setItem('login', this.login);
        localStorage.setItem(
          'auth',
          'Basic ' + btoa(this.login + ':' + this.password)
        );
        this.router.navigate(['/home']);
      },
      (error) => {
        this.message = 'infos incorrect';
      }
    );
  }
}
