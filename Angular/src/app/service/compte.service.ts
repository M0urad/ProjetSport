import { Compte } from './../model/compte';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  private static URL = 'http://localhost:8080/boot/api/compte';
  private httpHeader: HttpHeaders | any = null;

  constructor(private http: HttpClient) {}

  private initHeader() {
    this.httpHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa('admin:admin123'),
    });
  }

  public getAll(): Observable<Compte[]> {
    this.initHeader();
    return this.http.get<Compte[]>(CompteService.URL, {
      headers: this.httpHeader,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(CompteService.URL + '/' + id, {
      headers: this.httpHeader,
    });
  }

  public get(id: number): Observable<Compte> {
    this.initHeader();
    return this.http.get<Compte>(CompteService.URL + '/' + id, {
      headers: this.httpHeader,
    });
  }

  public create(compte: Compte): Observable<Compte> {
    this.initHeader();
    const produitFormate={
      id:compte.id,
      username:compte.username,
      password:compte.password,
      mail:compte.mail
    };

    return this.http.post<Compte>(CompteService.URL, produitFormate, {
      headers: this.httpHeader,
    });
  }

  public update(compte: Compte): Observable<Compte> {
    this.initHeader();
    console.log(compte);
    return this.http.put<Compte>(
      CompteService.URL + '/' + compte.id,
      compte,
      { headers: this.httpHeader }
    );
  }
}
