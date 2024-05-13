import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercheComponent } from './recherche.component';

describe('RechercheComponent', () => {
  let component: RechercheComponent;
  let fixture: ComponentFixture<RechercheComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RechercheComponent]
    });
    fixture = TestBed.createComponent(RechercheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
