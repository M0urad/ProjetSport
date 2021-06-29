import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  public login(login: string, password: string): Observable<boolean> {
    const header = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa(`${login}:${password}`),
    });
    return this.http.get<boolean>('http://localhost:8080/boot/api/compte', {
      headers: header,
    });
  }
}
