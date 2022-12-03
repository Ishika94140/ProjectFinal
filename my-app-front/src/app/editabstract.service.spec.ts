import { TestBed } from '@angular/core/testing';

import { EditabstractService } from './editabstract.service';

describe('EditabstractService', () => {
  let service: EditabstractService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EditabstractService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
