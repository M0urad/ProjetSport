import { Compte } from './../model/compte';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Joueur } from '../model/joueur';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  public login(login: string, password: string): Observable<Joueur> {
    const header = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa(`${login}:${password}`),
    });
    return this.http.get<Joueur>('http://localhost:8080/boot/api/compte/user', {
      headers: header,
    });
  }
}
