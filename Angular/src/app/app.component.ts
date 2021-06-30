import { Component, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './service/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Angular';
  message: String = '';

  constructor(private router: Router, private loginService: LoginService) {
    this.loginService.login, (this.message = '');
  }

  isLogged(): boolean {
    return localStorage.getItem('login') ? true : false;
  }

  logoff() {
    localStorage.clear();
    this.router.navigate(['/home']);
  }
}
