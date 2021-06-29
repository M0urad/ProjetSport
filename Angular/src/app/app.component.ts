import { Component, HostListener } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Angular';

  constructor(private router: Router) {}

  isLogged(): boolean {
    return localStorage.getItem('login') ? true : false;
  }

  logoff() {
    localStorage.clear();
    this.router.navigate(['/home']);
  }
}
