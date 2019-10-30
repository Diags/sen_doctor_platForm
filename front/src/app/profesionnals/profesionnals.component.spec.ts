import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfesionnalsComponent } from './profesionnals.component';

describe('ProfesionnalsComponent', () => {
  let component: ProfesionnalsComponent;
  let fixture: ComponentFixture<ProfesionnalsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfesionnalsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfesionnalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
