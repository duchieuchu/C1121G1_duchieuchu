import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListBookComponent} from './list-book/list-book.component';
import {CreateBookComponent} from './create-book/create-book.component';
import {EditBookComponent} from './edit-book/edit-book.component';
import {DetailBookComponent} from './detail-book/detail-book.component';


const routes: Routes = [
  {path: 'book/list', component: ListBookComponent},
  {path: 'book/add', component: CreateBookComponent},
  {path: 'book/edit/:id', component: EditBookComponent},
  {path: 'book/detail', component: DetailBookComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule {
}
