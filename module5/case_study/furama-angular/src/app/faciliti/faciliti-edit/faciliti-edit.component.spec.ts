import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilitiEditComponent } from './faciliti-edit.component';

describe('FacilitiEditComponent', () => {
  let component: FacilitiEditComponent;
  let fixture: ComponentFixture<FacilitiEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FacilitiEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilitiEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
