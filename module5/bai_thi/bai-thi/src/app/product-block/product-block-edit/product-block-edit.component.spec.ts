import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductBlockEditComponent } from './product-block-edit.component';

describe('ProductBlockEditComponent', () => {
  let component: ProductBlockEditComponent;
  let fixture: ComponentFixture<ProductBlockEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductBlockEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductBlockEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
