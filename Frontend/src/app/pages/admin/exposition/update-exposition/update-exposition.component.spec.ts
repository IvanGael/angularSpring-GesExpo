import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateExpositionComponent } from './update-exposition.component';

describe('UpdateExpositionComponent', () => {
  let component: UpdateExpositionComponent;
  let fixture: ComponentFixture<UpdateExpositionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateExpositionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateExpositionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
