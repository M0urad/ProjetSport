import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreaEventComponent } from './crea-event.component';

describe('CreaEventComponent', () => {
  let component: CreaEventComponent;
  let fixture: ComponentFixture<CreaEventComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreaEventComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreaEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
