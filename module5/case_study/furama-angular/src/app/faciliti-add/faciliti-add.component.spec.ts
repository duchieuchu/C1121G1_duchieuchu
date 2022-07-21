import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilitiAddComponent } from './faciliti-add.component';

describe('FacilitiAddComponent', () => {
  let component: FacilitiAddComponent;
  let fixture: ComponentFixture<FacilitiAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FacilitiAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilitiAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
