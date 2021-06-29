import { Compte } from './../model/compte';
import { CompteService } from './../service/compte.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  compte: Compte = new Compte();

  constructor(
    private CompteService: CompteService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params.id) {
        this.CompteService.get(params.id).subscribe((data) => {
          this.compte = data;
        });
      }
    });
  }

  save() {
    if (this.compte.id) {
      this.CompteService.update(this.compte).subscribe((result) => {
        this.router.navigate(['/home']);
      });
    } else {
      this.CompteService.create(this.compte).subscribe((result) => {
        this.router.navigate(['/home']);
      });
    }
  }
}
