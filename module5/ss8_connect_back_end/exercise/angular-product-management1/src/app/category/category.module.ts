import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CategoryListComponent} from './category-list/category-list.component';
import {CategoryCreateComponent} from './category-create/category-create.component';
import {CategoryEditComponent} from './category-edit/category-edit.component';
import {CategoryRoutingModule} from './category-routing.module';
import {ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [CategoryListComponent, CategoryCreateComponent, CategoryEditComponent],
  imports: [
    CommonModule, CategoryRoutingModule, ReactiveFormsModule
  ]
})
export class CategoryModule {
}
