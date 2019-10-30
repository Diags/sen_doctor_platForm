import { TestBed, async, inject } from '@angular/core/testing';

import { ProfesionnalsGuard } from './profesionnals.guard';

describe('ProfesionnalsGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProfesionnalsGuard]
    });
  });

  it('should ...', inject([ProfesionnalsGuard], (guard: ProfesionnalsGuard) => {
    expect(guard).toBeTruthy();
  }));
});
