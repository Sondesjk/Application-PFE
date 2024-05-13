import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandeeComponent } from './commandee.component';

describe('CommandeeComponent', () => {
  let component: CommandeeComponent;
  let fixture: ComponentFixture<CommandeeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CommandeeComponent]
    });
    fixture = TestBed.createComponent(CommandeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
