import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookRoutingModule } from './book-routing.module';
import { CreateBookComponent } from './create-book/create-book.component';
import { EditBookComponent } from './edit-book/edit-book.component';
import { ListBookComponent } from './list-book/list-book.component';
import { DetailBookComponent } from './detail-book/detail-book.component';


@NgModule({
  declarations: [CreateBookComponent, EditBookComponent, ListBookComponent, DetailBookComponent],
  imports: [
    CommonModule,
    BookRoutingModule
  ]
})
export class BookModule { }
