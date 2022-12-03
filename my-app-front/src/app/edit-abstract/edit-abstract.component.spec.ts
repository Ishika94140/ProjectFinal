import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAbstractComponent } from './edit-abstract.component';

describe('EditAbstractComponent', () => {
  let component: EditAbstractComponent;
  let fixture: ComponentFixture<EditAbstractComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditAbstractComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditAbstractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
