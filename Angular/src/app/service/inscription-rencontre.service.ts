import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Inscription } from '../model/inscription';

@Injectable({
  providedIn: 'root',
})
export class InscriptionRencontreService {
  private static URL = 'http://localhost:8080/boot/api/inscription';
  private httpHeader: HttpHeaders | any = null;
  constructor(private http: HttpClient) {}

  private initHeader() {
    const auth = localStorage.getItem('auth');
    this.httpHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: auth ? auth : '',
    });
  }

  public getAll(): Observable<Inscription[]> {
    this.initHeader();
    return this.http.get<Inscription[]>(InscriptionRencontreService.URL, {
      headers: this.httpHeader,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(
      InscriptionRencontreService.URL + '/delete/' + id,
      {
        headers: this.httpHeader,
      }
    );
  }

  public get(id: number): Observable<Inscription> {
    this.initHeader();
    return this.http.get<Inscription>(
      InscriptionRencontreService.URL + '/' + id,
      {
        headers: this.httpHeader,
      }
    );
  }

  public getInsAng(idRencontre: number): Observable<Inscription[]> {
    this.initHeader();
    return this.http.get<Inscription[]>(
      InscriptionRencontreService.URL + '/ang/' + idRencontre,
      {
        headers: this.httpHeader,
      }
    );
  }

  public sinscrire(
    id_rencontre: number,
    nbPlaces: number
  ): Observable<Inscription> {
    this.initHeader();
    const inscriptionFormatee = {
      placesReservees: nbPlaces,
    };

    return this.http.post<Inscription>(
      InscriptionRencontreService.URL + '/inscKey_renc/' + id_rencontre,
      inscriptionFormatee,
      {
        headers: this.httpHeader,
      }
    );
  }
}
