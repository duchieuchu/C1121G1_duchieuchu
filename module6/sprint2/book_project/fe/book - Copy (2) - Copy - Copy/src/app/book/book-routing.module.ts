import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListBookComponent} from './list-book/list-book.component';
import {CreateBookComponent} from './create-book/create-book.component';
import {EditBookComponent} from './edit-book/edit-book.component';
import {DetailBookComponent} from './detail-book/detail-book.component';
import {BookManagementComponent} from './book-management/book-management.component';
import {AuthGuard} from '../authguard/auth.guard';


const routes: Routes = [
  {path: 'book/list', component: ListBookComponent},
  {path: 'book/add', component: CreateBookComponent, canActivate: [AuthGuard]},
  {path: 'book/edit/:id', component: EditBookComponent, canActivate: [AuthGuard]},
  {path: 'book/detail/:id', component: DetailBookComponent},
  {path: 'book/management', component: BookManagementComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule {
}
