import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Error401PageComponent } from './error401-page.component';

describe('Error401PageComponent', () => {
  let component: Error401PageComponent;
  let fixture: ComponentFixture<Error401PageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Error401PageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Error401PageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
