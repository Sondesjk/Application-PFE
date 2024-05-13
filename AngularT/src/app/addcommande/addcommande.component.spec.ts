import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddcommandeComponent } from './addcommande.component';

describe('AddcommandeComponent', () => {
  let component: AddcommandeComponent;
  let fixture: ComponentFixture<AddcommandeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddcommandeComponent]
    });
    fixture = TestBed.createComponent(AddcommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
