import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfesionnalDetailsComponent } from './profesionnal-details.component';

describe('ProfesionnalDetailsComponent', () => {
  let component: ProfesionnalDetailsComponent;
  let fixture: ComponentFixture<ProfesionnalDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfesionnalDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfesionnalDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
