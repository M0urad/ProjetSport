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
}
