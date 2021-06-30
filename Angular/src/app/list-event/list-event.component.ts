import { Joueur } from './../model/joueur';
import { Inscription } from './../model/inscription';
import { LoginService } from './../service/login.service';
import { RencontreService } from './../service/rencontre.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Rencontre } from '../model/rencontre';

@Component({
  selector: 'app-list-event',
  templateUrl: './list-event.component.html',
  styleUrls: ['./list-event.component.css'],
})
export class ListEventComponent implements OnInit {
  rencontres: Observable<Rencontre[]> | any = null;

  constructor(private rencontreService: RencontreService) {}

  ngOnInit(): void {
    this.rencontres = this.rencontreService.getAll();

  }

  delete(id: number) {
    this.rencontreService.delete(id).subscribe((result) => {
      this.rencontres = this.rencontreService.getAll();
    });

  }
}
