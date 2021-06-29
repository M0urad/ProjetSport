import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Rencontre } from '../model/rencontre';

@Injectable({
  providedIn: 'root',
})
export class RencontreService {
  private static URL = 'http://localhost:8080/boot/api/rencontre';
  private httpHeader: HttpHeaders | any = null;

  constructor(private http: HttpClient) {}

  private initHeader() {
    this.httpHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa('admin:admin123'),
    });
  }

  public getAll(): Observable<Rencontre[]> {
    this.initHeader();
    return this.http.get<Rencontre[]>(RencontreService.URL, {
      headers: this.httpHeader,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(RencontreService.URL + '/' + id, {
      headers: this.httpHeader,
    });
  }

  public get(id: number): Observable<Rencontre> {
    this.initHeader();
    return this.http.get<Rencontre>(RencontreService.URL + '/' + id, {
      headers: this.httpHeader,
    });
  }

  public create(rencontre: Rencontre): Observable<Rencontre> {
    this.initHeader();
    const rencontreFormatee = {
      nom: rencontre.nom,
      date: rencontre.date,
      lieu: rencontre.lieu,
      nbPlaces: rencontre.nbPlaces,
      //inscription ?
      proprio: rencontre.proprio,
      messages: rencontre.messages,
    };

    return this.http.post<Rencontre>(RencontreService.URL, rencontreFormatee, {
      headers: this.httpHeader,
    });
  }

  public update(rencontre: Rencontre): Observable<Rencontre> {
    this.initHeader();
    const rencontreFormatee = {
      nom: rencontre.nom,
      date: rencontre.date,
      lieu: rencontre.lieu,
      nbPlaces: rencontre.nbPlaces,
      //inscription ?
      proprio: rencontre.proprio,
      messages: rencontre.messages,
    };
    return this.http.patch<Rencontre>(
      RencontreService.URL + '/' + rencontre.id,
      rencontreFormatee,
      { headers: this.httpHeader }
    );
  }
}
