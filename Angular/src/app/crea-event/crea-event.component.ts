import { RencontreService } from './../service/rencontre.service';
import { Rencontre } from './../model/rencontre';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crea-event',
  templateUrl: './crea-event.component.html',
  styleUrls: ['./crea-event.component.css'],
})
export class CreaEventComponent implements OnInit {
  rencontre: Rencontre = new Rencontre();

  constructor(
    private rencontreService: RencontreService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {}

  public save() {
    if (this.rencontre.id) {
      this.rencontreService.update(this.rencontre).subscribe((res) => {
        this.router.navigate(['/listEvents'], {
          queryParams: { update: this.rencontre.id },
        });
      });
    } else {
      this.rencontreService.create(this.rencontre).subscribe((res) => {
        this.router.navigate(['/listEvents'], {
          queryParams: { create: res.id },
        });
      });
    }
  }
}
