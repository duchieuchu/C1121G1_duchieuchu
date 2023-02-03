import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductCreateComponent } from './product-create/product-create.component';
import { ProductEditComponent } from './product-edit/product-edit.component';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [ProductListComponent, ProductCreateComponent, ProductEditComponent],
  imports: [
    CommonModule,
    ProductRoutingModule,
    HttpClientModule
  ]
})
export class ProductModule { }
