import { TestBed, async, inject } from '@angular/core/testing';

import { ProfesionnalDetailsGuard } from './profesionnal-details.guard';

describe('ProfesionnalDetailsGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProfesionnalDetailsGuard]
    });
  });

  it('should ...', inject([ProfesionnalDetailsGuard], (guard: ProfesionnalDetailsGuard) => {
    expect(guard).toBeTruthy();
  }));
});
