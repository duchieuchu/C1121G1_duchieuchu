import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductBlockListComponent } from './product-block-list.component';

describe('ProductBlockListComponent', () => {
  let component: ProductBlockListComponent;
  let fixture: ComponentFixture<ProductBlockListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductBlockListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductBlockListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
