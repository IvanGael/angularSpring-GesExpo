import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateOeuvreComponent } from './update-oeuvre.component';

describe('UpdateOeuvreComponent', () => {
  let component: UpdateOeuvreComponent;
  let fixture: ComponentFixture<UpdateOeuvreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateOeuvreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateOeuvreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
