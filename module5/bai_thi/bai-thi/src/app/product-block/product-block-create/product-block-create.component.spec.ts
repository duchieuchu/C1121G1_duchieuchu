import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductBlockCreateComponent } from './product-block-create.component';

describe('ProductBlockCreateComponent', () => {
  let component: ProductBlockCreateComponent;
  let fixture: ComponentFixture<ProductBlockCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductBlockCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductBlockCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
