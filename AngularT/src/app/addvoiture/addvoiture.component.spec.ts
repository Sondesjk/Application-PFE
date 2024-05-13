import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddvoitureComponent } from './addvoiture.component';

describe('AddvoitureComponent', () => {
  let component: AddvoitureComponent;
  let fixture: ComponentFixture<AddvoitureComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddvoitureComponent]
    });
    fixture = TestBed.createComponent(AddvoitureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
