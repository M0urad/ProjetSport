
import { TestBed } from '@angular/core/testing';

import { CompteService } from './compte.service';

describe('CompteService', () => {
  let compte: CompteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    compte = TestBed.inject(CompteService);
  });

  it('should be created', () => {
    expect(compte).toBeTruthy();
  });
});
