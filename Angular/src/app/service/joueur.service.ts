import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Joueur } from '../model/joueur';

@Injectable({
  providedIn: 'root',
})
export class JoueurService {
  private static URL = 'http://localhost:8080/boot/api/joueur';
  private httpHeader: HttpHeaders | any = null;

  constructor(private http: HttpClient) {}

  private initHeader() {
    const auth = localStorage.getItem('auth');
    this.httpHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: auth ? auth : '',
    });
  }

  public getAll(): Observable<Joueur[]> {
    this.initHeader();
    return this.http.get<Joueur[]>(JoueurService.URL, {
      headers: this.httpHeader,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(JoueurService.URL + '/' + id, {
      headers: this.httpHeader,
    });
  }

  public get(id: number): Observable<Joueur> {
    this.initHeader();
    return this.http.get<Joueur>(JoueurService.URL + '/' + id, {
      headers: this.httpHeader,
    });
  }

  public create(joueur: Joueur): Observable<Joueur> {
    this.initHeader();
    const joueurFormate = {
      id: joueur.id,
      username: joueur.username,
      password: joueur.password,
      email: joueur.mail,
      nom: joueur.nom,
      prenom: joueur.prenom,
      numTel: joueur.numTel,
    };
    console.log(joueurFormate);
    return this.http.post<Joueur>(JoueurService.URL, joueurFormate, {
      headers: this.httpHeader,
    });
  }

  public update(joueur: Joueur): Observable<Joueur> {
    this.initHeader();
    console.log(joueur);
    return this.http.put<Joueur>(JoueurService.URL + '/' + joueur.id, joueur, {
      headers: this.httpHeader,
    });
  }
}
