import { TestBed } from '@angular/core/testing';

import { InscriptionRencontreService } from './inscription-rencontre.service';

describe('InscriptionRencontreService', () => {
  let service: InscriptionRencontreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InscriptionRencontreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
